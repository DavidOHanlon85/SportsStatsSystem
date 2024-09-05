/**
 * 
 */
package p3;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class Player {

	// Instance Variables

	private String country;
	private String firstName;
	private String lastName;
	private Position position;
	private int totalMatches;
	private int pointsScored;
	private int gamesWon;
	private int gamesLost;
	private int gamesDrawn;
	private double heightInMetres;
	private String club;
	private int influence;
	private double percentageOfGamesWon;

	// Constructors

	/**
	 * Constructor no args
	 */
	public Player() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param country
	 * @param firstName
	 * @param lastName
	 * @param position
	 * @param totalMatches
	 * @param pointsScored
	 * @param gamesWon
	 * @param gamesLost
	 * @param gamesDrawn
	 * @param heightInMetres
	 * @param club
	 * @param influence
	 * @param percentageOfGamesWon
	 */
	public Player(String country, String firstName, String lastName, Position position, int totalMatches,
			int pointsScored, int gamesWon, int gamesLost, int gamesDrawn, double heightInMetres, String club,
			int influence) {
		this.setCountry(country);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPosition(position);
		this.setTotalMatches(totalMatches);
		this.setPointsScored(pointsScored);
		this.setGamesWon(gamesWon);
		this.setGamesLost(gamesLost);
		this.setGamesDrawn(gamesDrawn);
		this.setHeightInMetres(heightInMetres);
		this.setClub(club);
		this.setInfluence(influence);
		this.setPercentageOfGamesWon(gamesWon, totalMatches);
	}

	// Getters and Setters

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the totalMatches
	 */
	public int getTotalMatches() {
		return totalMatches;
	}

	/**
	 * @param totalMatches the totalMatches to set
	 */
	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	/**
	 * @return the pointsScored
	 */
	public int getPointsScored() {
		return pointsScored;
	}

	/**
	 * @param pointsScored the pointsScored to set
	 */
	public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored;
	}

	/**
	 * @return the gamesWon
	 */
	public int getGamesWon() {
		return gamesWon;
	}

	/**
	 * @param gamesWon the gamesWon to set
	 */
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	/**
	 * @return the gamesLost
	 */
	public int getGamesLost() {
		return gamesLost;
	}

	/**
	 * @param gamesLost the gamesLost to set
	 */
	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}

	/**
	 * @return the gamesDrawn
	 */
	public int getGamesDrawn() {
		return gamesDrawn;
	}

	/**
	 * @param gamesDrawn the gamesDrawn to set
	 */
	public void setGamesDrawn(int gamesDrawn) {
		this.gamesDrawn = gamesDrawn;
	}

	/**
	 * @return the heightInMetres
	 */
	public double getHeightInMetres() {
		return heightInMetres;
	}

	/**
	 * @param heightInMetres the heightInMetres to set
	 */
	public void setHeightInMetres(double heightInMetres) {
		this.heightInMetres = heightInMetres;
	}

	/**
	 * @return the club
	 */
	public String getClub() {
		return club;
	}

	/**
	 * @param club the club to set
	 */
	public void setClub(String club) {
		this.club = club;
	}

	/**
	 * @return the influence
	 */
	public int getInfluence() {
		return influence;
	}

	/**
	 * @param influence the influence to set
	 */
	public void setInfluence(int influence) {
		this.influence = influence;
	}

	/**
	 * @return the percentageOfGamesWon
	 */
	public double getPercentageOfGamesWon() {
		return percentageOfGamesWon;
	}

	/**
	 * @param percentageOfGamesWon the percentageOfGamesWon to set
	 */
	public void setPercentageOfGamesWon(int gamesWon, int totalMatches) {
		this.percentageOfGamesWon = (double) this.gamesWon / this.totalMatches * 100;
	}

	public void displayAllDetails() {

		System.out.println("Country           : " + getCountry());
		System.out.println("First name        : " + getFirstName());
		System.out.println("Last name         : " + getLastName());
		System.out.println("Position          : " + getPosition());
		System.out.println("Club              : " + getClub());
		System.out.println("Total Games       : " + getTotalMatches());
		System.out.println("Wins              : " + getGamesWon());
		System.out.println("Height            : " + getHeightInMetres());
		System.out.println("Points            : " + getPointsScored());
		System.out.println("Influence         : " + getInfluence());
		System.out.printf("Percent wins      : %.1f\n", getPercentageOfGamesWon());

	}

	public void SummaryForPointsScored() {

		System.out.printf("%s %s %s %d\n", getFirstName(), getLastName(), getCountry(), getPointsScored());

	}

	public void SummaryForHeight() {

		System.out.printf("%.2f %s %s\n", getHeightInMetres(), getFirstName(), getLastName());

	}

}
