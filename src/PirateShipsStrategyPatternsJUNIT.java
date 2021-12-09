import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;


public class PirateShipsStrategyPatternsJUNIT {

	PirateShipsStrategyPatterns ship = new PirateShipsStrategyPatterns();   //Creates the ship instance for PirateShipsStrategyPatterns
	
	@Test
	public void testGetShipLocation1() { 
		Point Actual = new Point(13,0) ;                    //Declared the Actual Point to 13,0
		Point Expected = ship.getShipLocation1();           //Calls the getshiplocation to get the initital location of ship
		assertEquals(Actual,Expected);                      //Compare the values
	}

	@Test
	public void testGetShipLocation2() {
		Point Actual = new Point(1,13) ;
		Point Expected = ship.getShipLocation2();
		assertEquals(Actual,Expected);
	}
	
	@Test
	public void testMove() {
		Point Actual = new Point(12,0) ;                       //Declared the Actual Point to 12,0
		ship.Move();                                           //Called the Move method
		Point Expected = ship.getShipLocation1();              //If the pirate ship reached the boundary then it should move backward
		assertEquals(Actual,Expected);                         //compare the actual and expected values
	}
	
	@Test
	public void testMove2() {
		Point Actual = new Point(2,13) ;
		ship.Move();
		Point Expected = ship.getShipLocation2();
		assertEquals(Actual,Expected);
	}
	
	
	
	
}
