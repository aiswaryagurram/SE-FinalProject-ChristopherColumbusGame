import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Treasure 														//create Treasure class to place the Treasure image
{
	ImageView TreasureImageView;
	final int scale = 50;
	int X =5,Y = 12;
	public void loadTreasureImage(AnchorPane root)							//loading the Treasure image on grid
	{
		Image treasureImage = new Image("treasure.png",50,50,true,true);
		TreasureImageView= new ImageView(treasureImage);
		TreasureImageView.setX(X*scale);
		TreasureImageView.setY(Y*scale);
		root.getChildren().add(TreasureImageView);
	}
	public Point getTreasureLoc() 											//gets the Treasure location
	{
		return new Point(X,Y);
	}
}
