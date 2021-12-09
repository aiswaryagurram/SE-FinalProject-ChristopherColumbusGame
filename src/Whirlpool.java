import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Whirlpool extends Decorator					//creates a concrete decorator class and extends Decorator class
{
	ImageView whirlpoolImageView;
	ImageView whirlpoolImageView1;
	ImageView whirlpoolImageView2;
	final int scale = 50;
	int X1 =6,Y1 = 9;
	int X2 = 7,Y2 = 1;
	int X3 = 9,Y3 = 7;
	ColumbusShip ship ;
	
	
	public Whirlpool(ColumbusShip ship1)
	{
		ship = ship1;
	}
	public void loadwhirlpoolImage(AnchorPane root) 					//loading the whirlpool images on grid
	{
		Image whirlpoolImage = new Image("whirlpool.jpg",49,54,true,true);
		whirlpoolImageView= new ImageView(whirlpoolImage);				//loading the whirlpool image 1 on grid
		whirlpoolImageView.setX(X1*scale);
		whirlpoolImageView.setY(Y1*scale);
		root.getChildren().add(whirlpoolImageView);
		
		whirlpoolImageView1= new ImageView(whirlpoolImage);				//loading the whirlpool image 2 on grid
		whirlpoolImageView1.setX(X2*scale);
		whirlpoolImageView1.setY(Y2*scale);
		root.getChildren().add(whirlpoolImageView1);
		
		whirlpoolImageView2= new ImageView(whirlpoolImage);				//loading the whirlpool image 3 on grid
		whirlpoolImageView2.setX(X3*scale);
		whirlpoolImageView2.setY(Y3*scale);
		root.getChildren().add(whirlpoolImageView2);
	}
	public Point getwhirlpoolLoc() 
	{
		return new Point(X1,Y1);
	}
	public Point getwhirlpoolLoc1() 
	{
		return new Point(X2,Y2);
	}
	public void goWest(Stage oceanStage,Point P1,Point P2,Point P3,Point P4)  //modifies the ship location methods  according to our requirement
	 {
		Point P = ship.getShipLocation();
		if(P.x == X1 && P.y == Y1 || P.x == X2 && P.y == Y2 || P.x == X3 && P.y == Y3) //If ship finds whirlpool,it gets protective powers
		{
		    ship.setShipLocation(P.x+2, P.y);										   //it moves in East direction i.e opposite to Whirlpool
		    ship.goEast(oceanStage, P4, P4, P4, P4); // add super at time of presentation super.goWest.......
		}
	 }
	public void goSouth(Stage oceanStage,Point P1,Point P2,Point P3,Point P4)
	 {
		Point P = ship.getShipLocation();
		if(P.x == X1 && P.y == Y1 || P.x == X2 && P.y == Y2 || P.x == X3 && P.y == Y3)
		{
			ship.setShipLocation(P.x, P.y-2);
		    ship.goNorth(oceanStage, P4, P4, P4, P4);									//ship moves in North direction i.e opposite to Whirlpool
		}
	 }
	public void goNorth(Stage oceanStage,Point P1,Point P2,Point P3,Point P4)
	 {
		Point P = ship.getShipLocation();
		if(P.x == X1 && P.y == Y1 || P.x == X2 && P.y == Y2 ||  P.x == X3 && P.y == Y3)
		{
			ship.setShipLocation(P.x, P.y+2);
		    ship.goSouth(oceanStage, P4, P4, P4, P4);									//ship moves in South direction i.e opposite to Whirlpool
		}
	 }
	public void goEast(Stage oceanStage,Point P1,Point P2,Point P3,Point P4)
	 {
		Point P = ship.getShipLocation();
		if(P.x == X1 && P.y == Y1 || P.x == X2 && P.y == Y2 ||  P.x == X3 && P.y == Y3)
		{
			ship.setShipLocation(P.x-2, P.y);
		    ship.goWest(oceanStage, P4, P4, P4, P4);									//ship moves in West direction i.e opposite to Whirlpool
		}
	 }
}
