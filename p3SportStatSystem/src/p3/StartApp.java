package p3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class StartApp {

	public static List<Player> players = new ArrayList<Player>();

	public static void main(String[] args) {
		readData();
		showMenu();

	}

	public static void showMenu() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Book reading ");
		do {
			System.out.println("1. Display all players");
			System.out.println("2. Display all players from Ireland");
			System.out.println("3. Display the highest point scorer ");
			System.out.println("4. Display all players by height and name");
			System.out.println(
					"5. Display each club (in alphabetical order with the cumulative number of games played in the six nations (Total Matches) by each player from that club ");
			System.out.println(
					"6. Capitalise the Last name and export/write to a new file in a new thread in the format Lastname, first name and country ");
			System.out.println("7. Quit");
			System.out.println("Enter option ...");
			option = scanner.nextInt();

			switch (option) {

			case 1:
				System.out.println("All players");
				System.out.println();
				displayAllPlayerDetails();
				System.out.println();
				break;
			case 2:
				String countryCode = "IRE";
				System.out.println("All player from " + countryCode);
				displayAllPlayerDetailsInList(filterbyCountry(players, countryCode));
				System.out.println();
				break;
			case 3:
				Collections.sort(players, new CompareByPointsScored().reversed());
				
				displaySummaryForPointsScored();
				break;
			case 4:
				Collections.sort(players, new CompareByHeight().reversed());
				
				for (Player p : players) {
					p.SummaryForHeight();
				}
				System.out.println();
				break;
			case 5:
				Map<String, Integer> clubAppearances = mapClubsToTotalAppearance();
				
				displayClubsAndTotalSixNationsAppearances(clubAppearances);
				
				break;
			case 6:
				WriteToFile wtf = new WriteToFile();
				Thread t1 = new Thread(wtf);
				t1.start();
				System.out.println("Thread started");
				break;
			case 7:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Try options again...");
			}
		} while (option != 7);
		scanner.close();
	}

	/**
	 * This method displays club and total club appearance at the 6 Nations
	 * 
	 * @param clubAppearances
	 */
	public static void displayClubsAndTotalSixNationsAppearances(Map<String, Integer> clubAppearances) {
		for (String key : clubAppearances.keySet()) {
			System.out.println(key + " " + clubAppearances.get(key));
		}
	}

	/**
	 * This method maps club to total club appearance at the 6 Nations
	 * 
	 * @return
	 */
	public static Map<String, Integer> mapClubsToTotalAppearance() {
		Map<String, Integer> clubAppearances = new TreeMap<String, Integer>();
		
		for (Player p : players) {
			if (clubAppearances.containsKey(p.getClub())) {
				int currentNumberOfGame = clubAppearances.get(p.getClub());
				clubAppearances.put(p.getClub(), (currentNumberOfGame + p.getTotalMatches()));
			} else {
				clubAppearances.put(p.getClub(), p.getTotalMatches());
			}
		}
		return clubAppearances;
	}

	/**
	 * This method displaysSummaryForPointsScored
	 */
	public static void displaySummaryForPointsScored() {
		for (Player p: players) {
			p.SummaryForPointsScored();
			System.out.println();
		}
	}

	/**
	 * This method displays all details of players in a list
	 * 
	 * @param filterbyCountry
	 */
	public static void displayAllPlayerDetailsInList(List<Player> filterbyCountry) {

		for (Player p : filterbyCountry) {
			p.displayAllDetails();
			System.out.println();
		}
	}

	/**
	 * This method displays all player details in the list
	 */
	public static void displayAllPlayerDetails() {
		for (Player p : players) {
			p.displayAllDetails();
			System.out.println();
		}
	}

	public static List<Player> filterbyCountry(List<Player> input, String countryCode) {

		List<Player> filteredByCountry = new ArrayList<Player>();

		for (Player p : input) {
			if (p.getCountry().equalsIgnoreCase(countryCode)) {
				filteredByCountry.add(p);
			}
		}

		return filteredByCountry;

	}

	/**
	 * Reads in the data from the csv and maps to the Player class
	 */
	public static void readData() {

		File file = new File("playerstats.csv");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			int attempedRead = 0;
			String line = "";

			line = br.readLine(); // remove header

			line = br.readLine(); // read first line

			while (line != null) {

				// split

				try {
					attempedRead++;

					String[] splitDetails = line.split(",");

					// create object

					Player p = createPlayerObject(splitDetails);

					players.add(p);

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				line = br.readLine();

			}

			System.out.println("Attempted Reads : " + attempedRead);
			System.out.println("Total Reads     : " + players.size());

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method creates a player object while reading in from file
	 * 
	 * @param splitDetails
	 * @return
	 * @throws Exception
	 */
	public static Player createPlayerObject(String[] splitDetails) throws Exception {
		int countryCode = Integer.parseInt(splitDetails[0]);

		Player p = new Player();

		// Set Country
		setCountryForEachObject(countryCode, p);

		setPlayersFirstAndLastName(splitDetails, p);

		p.setPosition(Position.valueOf(splitDetails[2].toUpperCase()));

		p.setTotalMatches(Integer.parseInt(splitDetails[3]));
		p.setPointsScored(Integer.parseInt(splitDetails[4]));
		p.setGamesWon(Integer.parseInt(splitDetails[5]));
		p.setGamesLost(Integer.parseInt(splitDetails[6]));
		p.setGamesDrawn(Integer.parseInt(splitDetails[7]));

		p.setHeightInMetres(Double.parseDouble(splitDetails[8]));

		p.setClub(splitDetails[9]);

		p.setInfluence(Integer.parseInt(splitDetails[10]));

		p.setPercentageOfGamesWon(p.getGamesWon(), p.getTotalMatches());
		return p;
	}

	/**
	 * This method takes the players full name and splits it into first and second
	 * names respectively
	 * 
	 * @param splitDetails
	 * @param p
	 */
	public static void setPlayersFirstAndLastName(String[] splitDetails, Player p) {
		String[] splitName = splitDetails[1].split(" ");

		p.setFirstName(splitName[0]);
		p.setLastName(splitName[1]);
	}

	/**
	 * This method sets the country for each incoming object based on the number
	 * code given in
	 * 
	 * @param countryCode
	 * @param p
	 * @throws Exception
	 */
	public static void setCountryForEachObject(int countryCode, Player p) throws Exception {
		switch (countryCode) {
		case 1:
			p.setCountry("ENG");
			break;
		case 2:
			p.setCountry("FRA");
			break;
		case 3:
			p.setCountry("IRE");
			break;
		case 4:
			p.setCountry("ITA");
			break;
		case 5:
			p.setCountry("SCO");
			break;
		case 6:
			p.setCountry("WAL");
			break;
		default:
			throw new Exception("Invalid Country Code");
		}
	}

}
