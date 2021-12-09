import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ColumbusShipJUNIT {
ColumbusShip ship = new ColumbusShip();             //Created a object to access the Columbus Ship class


@Test
public void testGetShipLocation() {                
Point Actual = new Point(0,0) ;                 //Declared the Actual Point to 0,0
Point Expected = ship.getShipLocation();        //Calls the getshiplocation to get the initital location of ship
assertEquals(Actual,Expected);                  //Compare the values

}

@Test
public void testsetShipLocation() {
   ship.setShipLocation(10,10);                       //Sets the ship location to 10,10
Point Actual = new Point(10,10) ;                  //Declared the location to 10,10
Point Expected = ship.getShipLocation();           //Gets the ship location
assertEquals(Actual,Expected);                   //Compare the values
}
@Test
public void testgoEast() {
Point Actual = new Point(11,10);                  //Declared the Actual Point to 11,10
Stage oceanStage = null;                          
ship.setShipLocation(10,10);                      //Sets the ship location to 10,10
//Calls the goEast method if everything is passed then it increments the x coordinate by 1
ship.goEast(oceanStage, new Point(6,10), new Point(12,8), new Point(13,1), new Point(10,6));
   Point Expected = ship.getShipLocation();          //gets the ship location
assertEquals(Actual,Expected);                  //Compares the actual and expected values
}

@Test
public void testgoWest() {
Point Actual = new Point(9,10);                    //Declared the Actual Point to 9,10
Stage oceanStage = null;  
ship.setShipLocation(10,10);                       //Sets the ship location to 10,10
//Calls the goWest method if everything is passed then it decrements the x coordinate by 1
ship.goWest(oceanStage, new Point(6,10), new Point(12,8), new Point(13,1), new Point(10,6));
Point Expected = ship.getShipLocation();           //gets the ship location
assertEquals(Actual,Expected);                   //Compares the actual and expected values
}

@Test
public void testgoSouth() {
Point Actual = new Point(10,11);                 //Declared the Actual Point to 10,11
Stage oceanStage = null;
ship.setShipLocation(10,10);                     //Sets the ship location to 10,10
//Calls the goSouth method if everything is passed then it increments the y coordinate by 1
ship.goSouth(oceanStage, new Point(6,10), new Point(12,8), new Point(13,1), new Point(10,6));
Point Expected = ship.getShipLocation();         //gets the ship location
assertEquals(Actual,Expected);                 //Compares the actual and expected values
}

@Test
public void testgoNorth() {
Point Actual = new Point(10,9);                   //Declared the Actual Point to 10,11
Stage oceanStage = null;
ship.setShipLocation(10,10);                      //Sets the ship location to 10,10
//Calls the goSouth method if everything is passed then it decrements the y coordinate by 1
ship.goNorth(oceanStage, new Point(6,10), new Point(12,8), new Point(13,1), new Point(10,6));
Point Expected = ship.getShipLocation();            //gets the ship location
assertEquals(Actual,Expected);                    //Compares the actual and expected values
}

}