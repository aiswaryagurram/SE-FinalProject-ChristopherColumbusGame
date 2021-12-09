import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class PirateShip1JUNIT {
    PirateShip1 ship = new PirateShip1();            //Creates the ship instance to call PirateShip1 class
	@Test
	public void testGetShipLocation() {
		Point Actual = new Point(2,2) ;              //Defined the Actual Point 2,2
		Point Expected = ship.getShipLocation();     //Gets the expected ship location from the getshiplocation method
		assertEquals(Actual,Expected);               //Compares the Actual and expected Point values
	}

}
