package p3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlayer {

	// input data
	
	String validcountry, validFirstName, validLastName, validClub;
	Position back, forward;
	int validInputInt;
	double validDoubleInput;
	
	Player p;
	
	@BeforeEach
	void setUp() throws Exception {
	
		validcountry = "SCO";
		validFirstName = "Sam" ;
		validLastName = "Johnson"; 
		validClub = "Glasgow";
		
		back = Position.BACK;
		forward = Position.FORWARD;
		validInputInt = 23;
		validDoubleInput = 1.25;
		
		p = new Player(validcountry, validFirstName, validLastName, back, validInputInt, validInputInt, validInputInt, validInputInt, validInputInt, validDoubleInput, validClub, validInputInt);
		
		
	}

	@Test
	void testPlayerNoArgs() {
		assertNotNull(p);
	}

	@Test
	void testPlayerStringStringStringPositionIntIntIntIntIntDoubleStringInt() {
		assertEquals(validcountry, p.getCountry());
		assertEquals(validFirstName, p.getFirstName());
		assertEquals(validLastName, p.getLastName());
		assertEquals(back, p.getPosition());
		assertEquals(validInputInt, p.getTotalMatches());
		assertEquals(validInputInt, p.getPointsScored());
		assertEquals(validInputInt, p.getGamesWon());
		assertEquals(validInputInt, p.getGamesLost());
		assertEquals(validInputInt, p.getGamesDrawn());
		assertEquals(validDoubleInput, p.getHeightInMetres());
		assertEquals(validClub, p.getClub());
		assertEquals(validInputInt, p.getInfluence());
		assertEquals(100.0, p.getPercentageOfGamesWon());
	}

	@Test
	void testSetGetCountry() {
		p.setCountry(validcountry);
		assertEquals(validcountry, p.getCountry());
	}

	@Test
	void testSetGetFirstName() {
		p.setFirstName(validFirstName);
		assertEquals(validFirstName, p.getFirstName());
	}

	@Test
	void testSetGetLastName() {
		p.setLastName(validLastName);
		assertEquals(validLastName, p.getLastName());
	}

	@Test
	void testSetGetPosition() {
		p.setPosition(back);
		assertEquals(back, p.getPosition());
		
		p.setPosition(forward);
		assertEquals(forward, p.getPosition());
	}


	@Test
	void testSetGetTotalMatches() {
		p.setTotalMatches(validInputInt);
		assertEquals(validInputInt, p.getTotalMatches());
	}

	@Test
	void testGetPointsScored() {
		p.setPointsScored(validInputInt);
		assertEquals(validInputInt, p.getPointsScored());
	}

	@Test
	void testSetGetGamesWon() {
		p.setGamesWon(validInputInt);
		assertEquals(validInputInt, p.getGamesWon());
	}

	@Test
	void testSetGetGamesLost() {
		p.setGamesLost(validInputInt);
		assertEquals(validInputInt, p.getGamesLost());
	}

	@Test
	void testSetGetGamesDrawn() {
		p.setGamesDrawn(validInputInt);
		assertEquals(validInputInt, p.getGamesDrawn());
	}

	@Test
	void testGetHeightInMetres() {
		p.setHeightInMetres(validDoubleInput);
		assertEquals(validDoubleInput, p.getHeightInMetres());
	}

	@Test
	void testSetGetClub() {
		p.setClub(validClub);
		assertEquals(validClub, p.getClub());
	}

	@Test
	void testGetInfluence() {
		p.setInfluence(validInputInt);
		assertEquals(validInputInt, p.getInfluence());
	}

	@Test
	void testGetPercentageOfGamesWon() {
		p = new Player(validcountry, validFirstName, validLastName, back, validInputInt, validInputInt, validInputInt, validInputInt, validInputInt, validDoubleInput, validClub, validInputInt);
		assertEquals(100.0, p.getPercentageOfGamesWon());
		
		p = new Player(validcountry, validFirstName, validLastName, back, 20, validInputInt, 5, validInputInt, validInputInt, validDoubleInput, validClub, validInputInt);
		assertEquals(25.0, p.getPercentageOfGamesWon());
		
		
	}

}
