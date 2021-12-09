import java.awt.Point;

import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

class ColumbusShip extends Ship implements DecoratorInterface	//extends ship and implements Decorator Interface
{
	ImageView shipImageView;
	final int scale = 50;
	int X,Y;
	int IslocX[] = new int[] {2,13,11,1};
	int IslocY[] = new int[] {6,0,11,13};
 
	int P1x,P1y;
	int P2x,P2y;

 public Point getShipLocation()                           //Returns the current Ship Location
 {
 	return new Point(X,Y);
 }
 public void setShipLocation(int x,int y)                 //Sets the Ship Location
 {
 	X = x;
 	Y = y;
 }
 public void setPirateShip1loc(int x, int y)			  //sets the pirate ships locations
 {            
	P1x = x;
	P1y = y;
 }
 public void setPirateShip2loc(int x, int y)
 {
		P2x = x;
		P2y = y;
 }
 @Override
 public void goWest(Stage oceanStage,Point P1,Point P2,Point P3,Point P4) //method to move ship to right side
{

	   Boolean iscellempty = true;
	   if (X != 0)
		{
		 //Checks if the Ship has reached the treasure.If yes then it pops the You Won dialog Box and resets the game.
		   if(X == 5 && Y == 12)
			{
				JOptionPane.showMessageDialog(null, "CONGRATS,YOU FOUND THE TREASURE.CLICK OK TO PLAY NEW GAME", "YOU WON", JOptionPane.INFORMATION_MESSAGE);
				if(JOptionPane.OK_OPTION == 0)
				{
					MapGridSingleton map = new MapGridSingleton();
					try 
					{
						map.start(oceanStage);
					} catch (Exception e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				              
				 }
			}
			//If the Ship is caught with any of the pirate ships then it throws the you lost dialogue and resets the game
			else if (P1x == X && P1y == Y || P2x == X && P2y == Y || P1.x == X && P1.y == Y || P2.x == X &&
					P2.y == Y || P3.x == X && P3.y == Y ||  P4.x == X && P4.y == Y )
			{
				JOptionPane.showMessageDialog(null, "SORRY,YOU LOST", "YOU LOST.CLICK OK TO PLAY NEW GAME", JOptionPane.INFORMATION_MESSAGE);
				if(JOptionPane.OK_OPTION == 0)
				{
					
					MapGridSingleton map = new MapGridSingleton();
					try {
						map.start(oceanStage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				              
				 }
			}
		   // Else it moves the ship backward and notify the observers.
			else
			{
			X--;
			setChanged();
			notifyObservers();
			}
		
		}
	   //If the ship reaches boundary and if it is caught by the pirate ships then it throws error
	   else if (P1x == X && P1y == Y || P2x == X && P2y == Y || P1.x == X && P1.y == Y || P2.x == X &&
				P2.y == Y || P3.x == X && P3.y == Y ||  P4.x == X && P4.y == Y )
		{
			JOptionPane.showMessageDialog(null, "SORRY,YOU LOST", "YOU LOST.CLICK OK TO PLAY NEW GAME", JOptionPane.INFORMATION_MESSAGE);
			if(JOptionPane.OK_OPTION == 0)
			{
				
				MapGridSingleton map = new MapGridSingleton();
				try 
				{
					map.start(oceanStage);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			              
			 }
		}
	}
    @Override
	public void goSouth(Stage oceanStage,Point P1,Point P2,Point P3,Point P4) //method to move ship to  down side
	{
		// TODO Auto-generated method stub
		Boolean iscellempty = true;
		if (Y != 13)
		{
			//Checks if the Ship has reached the treasure.If yes then it pops the You Won dialog Box and resets the game.
			if(X == 5 && Y == 12)
				{
					JOptionPane.showMessageDialog(null, "CONGRATS,YOU FOUND THE TREASURE.CLICK OK TO PLAY NEW GAME", "YOU WON", JOptionPane.INFORMATION_MESSAGE);
					if(JOptionPane.OK_OPTION == 0)
					{
						
						MapGridSingleton map = new MapGridSingleton();
						try 
						{
							map.start(oceanStage);
						} catch (Exception e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					              
					 }
				}
			//If the Ship is caught with any of the pirate ships then it throws the you lost dialogue and resets the game
				else if (P1x == X && P1y == Y || P2x == X && P2y == Y || P1.x == X && P1.y == Y || P2.x == X &&
						P2.y == Y || P3.x == X && P3.y == Y ||  P4.x == X && P4.y == Y )
				{
					JOptionPane.showMessageDialog(null, "SORRY,YOU LOST", "YOU LOST.CLICK OK TO PLAY NEW GAME", JOptionPane.INFORMATION_MESSAGE);
					if(JOptionPane.OK_OPTION == 0)
					{
						
						MapGridSingleton map = new MapGridSingleton();
						try 
						{
							map.start(oceanStage);
						} catch (Exception e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					              
					 }
				}
			  // Else it moves the ship backward and notify the observers.
				else
				{
					Y++;
					setChanged();
					notifyObservers();
				}
			}
		  //If the ship reaches boundary and if it is caught by the pirate ships then it throws error
		else if (P1x == X && P1y == Y || P2x == X && P2y == Y || P1.x == X && P1.y == Y || P2.x == X &&
				P2.y == Y || P3.x == X && P3.y == Y ||  P4.x == X && P4.y == Y )
		{
			JOptionPane.showMessageDialog(null, "SORRY,YOU LOST", "YOU LOST.CLICK OK TO PLAY NEW GAME", JOptionPane.INFORMATION_MESSAGE);
			if(JOptionPane.OK_OPTION == 0)
			{
				
				MapGridSingleton map = new MapGridSingleton();
				try {
					map.start(oceanStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			              
			 }
		}
		
	}
    @Override
	public void goNorth(Stage oceanStage,Point P1,Point P2,Point P3,Point P4) //method to move ship to  Up side
	{
		// TODO Auto-generated method stub
		Boolean iscellempty = true;
		if (Y != 0)
		{
			//Checks if the Ship has reached the treasure.If yes then it pops the You Won dialog Box and resets the game.
				if(X == 5 && Y == 12)
				{
					JOptionPane.showMessageDialog(null, "CONGRATS,YOU FOUND THE TREASURE.CLICK OK TO PLAY NEW GAME", "YOU WON", JOptionPane.INFORMATION_MESSAGE);
					if(JOptionPane.OK_OPTION == 0)
					{
						
						MapGridSingleton map = new MapGridSingleton();
						try 
						{
							map.start(oceanStage);
						} catch (Exception e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					              
					 }
				}
				//If the Ship is caught with any of the pirate ships then it throws the you lost dialogue and resets the game
				else if (P1x == X && P1y == Y || P2x == X && P2y == Y || P1.x == X && P1.y == Y || P2.x == X &&
						P2.y == Y || P3.x == X && P3.y == Y ||  P4.x == X && P4.y == Y )
				{
					JOptionPane.showMessageDialog(null, "SORRY,YOU LOST", "YOU LOST.CLICK OK TO PLAY NEW GAME", JOptionPane.INFORMATION_MESSAGE);
					if(JOptionPane.OK_OPTION == 0)
					{
						
						MapGridSingleton map = new MapGridSingleton();
						try
						{
							map.start(oceanStage);
						} catch (Exception e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					              
					 }
				}
				  // Else it moves the ship backward and notify the observers.
				else
				{
					Y--;
					setChanged();
					notifyObservers();
				}
			}
		//If the ship reaches boundary and if it is caught by the pirate ships then it throws error
		else if (P1x == X && P1y == Y || P2x == X && P2y == Y || P1.x == X && P1.y == Y || P2.x == X &&
				P2.y == Y || P3.x == X && P3.y == Y ||  P4.x == X && P4.y == Y )
		{
			JOptionPane.showMessageDialog(null, "SORRY,YOU LOST", "YOU LOST.CLICK OK TO PLAY NEW GAME", JOptionPane.INFORMATION_MESSAGE);
			if(JOptionPane.OK_OPTION == 0)
			{
				
				MapGridSingleton map = new MapGridSingleton();
				try {
					map.start(oceanStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			              
			 }
		}
		
	}
    @Override
	public void goEast(Stage oceanStage,Point P1,Point P2,Point P3,Point P4) //method to move ship to  left side
	{
		// TODO Auto-generated method stub
		Boolean iscellempty = true;
		if (X != 13)
		{
			//Checks if the Ship has reached the treasure.If yes then it pops the You Won dialog Box and resets the game.
				if(X == 5 && Y == 12)
				{
					JOptionPane.showMessageDialog(null, "CONGRATS,YOU FOUND THE TREASURE.CLICK OK TO PLAY NEW GAME", "YOU WON", JOptionPane.INFORMATION_MESSAGE);
					if(JOptionPane.OK_OPTION == 0)
					{
						
						MapGridSingleton map = new MapGridSingleton();
						try 
						{
							map.start(oceanStage);
						} catch (Exception e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					              
					 }
				}
				//If the Ship is caught with any of the pirate ships then it throws the you lost dialogue and resets the game
				else if (P1x == X && P1y == Y || P2x == X && P2y == Y || P1.x == X && P1.y == Y || P2.x == X &&
						P2.y == Y || P3.x == X && P3.y == Y ||  P4.x == X && P4.y == Y )
				{
					JOptionPane.showMessageDialog(null, "SORRY,YOU LOST", "YOU LOST.CLICK OK TO PLAY NEW GAME", JOptionPane.INFORMATION_MESSAGE);
					if(JOptionPane.OK_OPTION == 0)
					{
						
						MapGridSingleton map = new MapGridSingleton();
						try
						{
							map.start(oceanStage);
						} catch (Exception e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					              
					 }
				}
				  // Else it moves the ship backward and notify the observers.
				else
				{
					
					X++;
					setChanged();
					notifyObservers();
				}
			}
		//If the ship reaches boundary and if it is caught by the pirate ships then it throws error
		else if (P1x == X && P1y == Y || P2x == X && P2y == Y || P1.x == X && P1.y == Y || P2.x == X &&
				P2.y == Y || P3.x == X && P3.y == Y ||  P4.x == X && P4.y == Y )
		{
			JOptionPane.showMessageDialog(null, "SORRY,YOU LOST", "YOU LOST.CLICK OK TO PLAY NEW GAME", JOptionPane.INFORMATION_MESSAGE);
			if(JOptionPane.OK_OPTION == 0)
			{
				
				MapGridSingleton map = new MapGridSingleton();
				try 
				{
					map.start(oceanStage);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			              
			 }
		}
		
	}
                                                
@Override
public ImageView loadShipImage(AnchorPane root) 					//It loads the ship image on the Map
{
	Image shipImage = new Image("ship.png",50,50,true,true);
	shipImageView= new ImageView(shipImage);
	shipImageView.setX(10*scale);
	shipImageView.setY(10*scale);
	setShipLocation(10,10);
	root.getChildren().add(shipImageView);	
	return shipImageView;
}

}