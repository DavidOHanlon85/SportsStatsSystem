package p3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player p = new Player("England", "Paul", "John", Position.BACK, 100, 200, 20, 0, 0, 1.23, "Munster", 20);
		//Player p2 = new Player(country, firstName, lastName, position, totalMatches, pointsScored, gamesWon, gamesLost, gamesDrawn, heightInMetres, club, influence)
		
		p.toString();
		
		System.out.println(p.toString());

	}

}
