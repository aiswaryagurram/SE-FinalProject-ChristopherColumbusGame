import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class PirateShip2JUNIT {

	 Pirateship2 ship = new Pirateship2();                       //Creates the ship instance to call PirateShip2 class
		@Test
		public void testGetShipLocation() {
			Point Actual = new Point(4,5) ;                      //Defined the Actual Point 4,5
			Point Expected = ship.getShipLocation();             //Gets the expected ship location from the getshiplocation method
			assertEquals(Actual,Expected);                         //Compares the Actual and expected Point values
		}

		

}
