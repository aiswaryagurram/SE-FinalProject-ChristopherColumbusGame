import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

class PirateShip1 extends Ship implements Observer           //Extends the ship method to set the different images and different origins
{
	int IslocX[] = new int[] {5,6,7,9};
	int IslocY[] = new int[] {12,9,1,7};

	ImageView shipImageView;
	final int scale = 50;
	Point Shippos;
	int X1 = 2,Y1 = 2;
	@Override
	public ImageView loadShipImage(AnchorPane root)
	{

		Image shipImage = new Image("pirateShip.png",50,50,true,true);
		shipImageView= new ImageView(shipImage);                               //loads the shipimage
		shipImageView.setX(2*scale);
		shipImageView.setY(2*scale);
		root.getChildren().add(shipImageView);                                 //adds the image to the root
		return shipImageView;
	}
	public Point getShipLocation()
	{
		return new Point(X1,Y1);                                              //Returns the shiplocation
	}
	public void Movement()
	{
		if (X1 - Shippos.x == 0) {
        } 
		else if (X1- Shippos.x < 0)                                 //Checks if the pirate ship is left of the columbus ship
		{
			if (X1 < 13 )
			{
				Boolean iscellempty = true;
				for(int i=0;i<IslocX.length;i++)
				{
					if(X1+1 == IslocX[i] && Y1 == IslocY[i])                     //Checks if the pirate ship location with other ships location
					{
						iscellempty =false;
						break;
					}
     
				}
				if(iscellempty)
					X1++;                                                    //If all the validations are passed then it moves the pirate ship forward
			}
		}
		else if (X1 > 0 )                                          //Checks if the pirate ship is right side of the columbus ship
		{
			Boolean iscellempty = true;
			for(int i=0;i<IslocX.length;i++)
			{
				if(X1-1 == IslocX[i] && Y1 == IslocY[i])
				{
					iscellempty =false;
					break;
				}
     
			}
			if(iscellempty)
				X1--;                                                        //If the ship reached the 0 then it moved the pirate ship backward
		}

 
		if (Y1 - Shippos.y == 0) {
		}
		else if (Y1 - Shippos.y < 0)                                //Checks if pirate ship is below the columbus ship
		{
     
          if (Y1 < 13)                                              //Checks if Y1 is less than 13
          {
        	  Boolean iscellempty = true;
        	  for(int i=0;i<IslocY.length;i++)
        	  {
        		  if(X1 == IslocX[i] && Y1+1 == IslocY[i])
        		  {
        			  iscellempty =false;                                               //Checks the location of pirate ships with other pirate ships
        			  break;
        		  }
        	  }
        	  if(iscellempty)
        		  Y1++;                                                    //Increments the Y1
          }
		}
		else if (Y1 > 0)                                            //If pirate ship is above the columbus ship then it comed down
		{
			Boolean iscellempty = true;
			for(int i=0;i<IslocY.length;i++)
			{
				if(X1 == IslocX[i] && Y1-1 == IslocY[i])
				{
					iscellempty =false;
					break;
				}
			}
			if(iscellempty)
				Y1--;                                                          //Decrements the Y corodinate
		}



	}
	@Override
	public void update(Observable S, Object arg)
	{
		if(S instanceof ColumbusShip)
		{
			Shippos = ((ColumbusShip)S).getShipLocation();                     //Gets the current columbus ship location
			Movement();                                                        //Calls the Movement method
		}              

	}
}
