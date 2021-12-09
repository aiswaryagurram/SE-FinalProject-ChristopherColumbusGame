import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

class PirateShipsStrategyPatterns extends Ship implements StrategyInterface   //Creates concrete classes and implements strategy interface
{
	 ImageView shipImageView;
	 ImageView shipImageView1;
	 Boolean dec = false;
	 Boolean dec1 = false;
	 final int scale = 50;
	 int x1 = 13,y1 = 0;
	 int x2 = 1 ,y2 = 13;
	@Override
	ImageView loadShipImage(AnchorPane root)							      //loads the pirateship images 
	{
		Image shipImage = new Image("pirateShip.png",50,50,true,true);
		shipImageView= new ImageView(shipImage);
		shipImageView.setX(x1*scale);
		shipImageView.setY(y1*scale);
		root.getChildren().add(shipImageView);
	
		shipImageView1= new ImageView(shipImage);
		shipImageView1.setX(x2*scale);
		shipImageView1.setY(y2*scale);
		root.getChildren().add(shipImageView1);
		
		return shipImageView;
	}
	@Override
	public void MoveStrategy() 												 //Using MoveStrategy to patrol the Pirateships in grid 
	{
		Move();
		shipImageView.setX(x1 * scale); 									// Sets the updated PirateShipImageview
		shipImageView.setY(y1* scale);
		shipImageView1.setX(x2 * scale);							    	// Sets the updated PirateShipImageview
		shipImageView1.setY(y2* scale);
	}
	public void Move()
	{
		 //Pirateships patrol  in horizontal  directions in grid
if(x1+1 != 14 && dec == false)
{
x1 = x1 + 1;
}
else if(x1 != 0)
{
dec = true;
x1 = x1-1;
}
else
{
dec = false;
}
if(x2+1 != 14 && dec1 == false )
{
x2 = x2+1;
}
else if(x2 != 0)
{
dec1 = true;
x2 = x2 -1;
}
else
{
dec1 = false;
}
	}
	public Point getShipLocation1() 										//returns pirateship1 location
	{
		
	 	return new Point(x1,y1);
	}
	public Point getShipLocation2() 										//returns pirateship2 location
	{
		
	 	return new Point(x2,y2);
	}
	
}

class PirateShipsStrategyPatterns2 extends Ship implements StrategyInterface  //implements strategy interface for other 2 Pirateships
{
	
	 ImageView shipImageView2;
	 ImageView shipImageView3;
	 final int scale = 50;
	 int x1 = 11,y1 = 11;
	 int x2 = 2 ,y2 = 6;
	 Boolean dec = false;
	 Boolean dec1 = false;
	@Override
	ImageView loadShipImage(AnchorPane root) 								  //Loading the PirateShip images to grid
	{
		Image shipImage = new Image("pirateShip.png",50,50,true,true);
	
		
		shipImageView2= new ImageView(shipImage);
		shipImageView2.setX(x1*scale);
		shipImageView2.setY(y1*scale);
		root.getChildren().add(shipImageView2);
		
		shipImageView3= new ImageView(shipImage);
		shipImageView3.setX(x2*scale);
		shipImageView3.setY(y2*scale);
		root.getChildren().add(shipImageView3);
		return shipImageView2;
	}
	@Override
	public void MoveStrategy() 												//Using MoveStrategy to patrol the Pirateships in grid
	{
																			//PrirateShips patrol in Vertical directions in grid
		if(y1+1 != 14 && dec == false)
		{
			y1 = y1 + 1;
		}
		else if(y1 != 0)
		{
			dec = true;
			y1 = y1-1;
		}
		else
		{
			dec = false;
		}
		if(y2+1 != 14 && dec1 == false )
		{
			y2 = y2+1;
		}
		else if(y2 != 0)
		{
			dec1 = true;
			y2 = y2 -1;
		}
		else
		{
			dec1 = false;
		}
		shipImageView2.setX(x1 * scale);									  // Sets the updated ShipImageview
		shipImageView2.setY(y1* scale);
		shipImageView3.setX(x2 * scale);									  // Sets the updated ShipImageview
		shipImageView3.setY(y2* scale);
	}
	public Point getShipLocation1() 										  //returns pirateship1 location patrols in vertical direction
	{
		
	 	return new Point(x1,y1);
	}
	public Point getShipLocation2() 										  //returns pirateship2 location patrols in vertical direction
	{
		
	 	return new Point(x2,y2);
	}
}

 class Strategy 
 {
	   private StrategyInterface strategy;

	   public  Strategy(StrategyInterface strategy)
	   {
	      this.strategy = strategy;
	   }

	   public void executeStrategy()
	   {
	      strategy.MoveStrategy();
	   }
  }
