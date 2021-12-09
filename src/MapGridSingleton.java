import java.awt.Point;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MapGridSingleton extends Application{
//Declaring the instance for the Singleton Class
private static final MapGridSingleton instance= new MapGridSingleton();
AnchorPane root;
final int scale = 50;
final int dimension=50;
ImageView shipImageView;
ImageView PirateImageView1;
ImageView PirateImageView2;
ImageView PirateImageView3;
ImageView PirateImageView4;
int shiplocx = 10;
int shiplocy = 10;
public MapGridSingleton() {}
//Overrides the start method
public void start(Stage oceanStage) throws Exception
{

	root = new AnchorPane();
	Scene scene = new Scene(root,700,700);                //Sets the new Scene
	oceanStage.setScene(scene);
	oceanStage.setTitle("ColumbusGame");                  //Sets the title for the game 
	oceanStage.show();
                                                      	  //Adds the grid to the Map
for(int a = 0; a < dimension; a++)
{
	for(int b = 0; b < dimension; b++)
	{
	Rectangle rect = new Rectangle(a*scale,b*scale,scale,scale);
	rect.setStroke(Color.BLACK);
	rect.setFill(Color.PALETURQUOISE);
	root.getChildren().add(rect);
	}
} 
                                                        
ColumbusShip ship1 = new ColumbusShip();
oceanStage.setScene(scene);
shipImageView = ship1.loadShipImage(root);

PirateShip1 ship2 = new PirateShip1();
ship1.addObserver(ship2);
oceanStage.setScene(scene);

PirateImageView1 = ship2.loadShipImage(root);
ship1.setPirateShip1loc(ship2.getShipLocation().x, ship2.getShipLocation().y);

Pirateship2 ship3 = new Pirateship2();
ship1.addObserver(ship3);
oceanStage.setScene(scene);
PirateImageView2 = ship3.loadShipImage(root);

Strategy strategy1 = new Strategy(new PirateShipsStrategyPatterns());
Strategy strategy2 = new Strategy(new PirateShipsStrategyPatterns2());

PirateShipsStrategyPatterns ship4 = new PirateShipsStrategyPatterns();
oceanStage.setScene(scene);
PirateImageView3 = ship4.loadShipImage(root);

PirateShipsStrategyPatterns2 ship5 = new PirateShipsStrategyPatterns2();
oceanStage.setScene(scene);
PirateImageView4 = ship5.loadShipImage(root);

Treasure t = new Treasure();
oceanStage.setScene(scene);
t.loadTreasureImage(root);

Whirlpool w = new Whirlpool(ship1);
oceanStage.setScene(scene);
w.loadwhirlpoolImage(root);

startSailing(scene,ship1,ship2,ship3,ship4,ship5,strategy1,strategy2,w,oceanStage);
}
//The below method is called when the arrows are pressed towards Right,Left,Up,Down 
private void startSailing(Scene scene, ColumbusShip ship,PirateShip1 ship1,Pirateship2 ship2,PirateShipsStrategyPatterns ship4,PirateShipsStrategyPatterns2 ship5,Strategy strategy1,Strategy strategy2,Whirlpool W,Stage oceanStage) 
{
	scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
	{
		@Override
		public void handle(KeyEvent ke) 
		{
			
			Point P1 = ship4.getShipLocation1();
			Point P2 = ship4.getShipLocation2();
			Point P3 = ship5.getShipLocation1();
			Point P4 = ship5.getShipLocation2();
			switch (ke.getCode())
			{
			case RIGHT: 
				ship.goEast(oceanStage,P1,P2,P3,P4); 			// moves the ship to right
				W.goEast(oceanStage, P1, P2, P3, P4);
				break;
			case LEFT:
				ship.goWest(oceanStage,P1,P2,P3,P4);			//moves the ship to left
				W.goWest(oceanStage, P1, P2, P3, P4);
				break;
			case UP:
				ship.goNorth(oceanStage,P1,P2,P3,P4);			// moves the ship to up
				W.goNorth(oceanStage, P1, P2, P3, P4);
				break;
			case DOWN:
				ship.goSouth(oceanStage,P1,P2,P3,P4); 			// moves the ship to down
				W.goSouth(oceanStage, P1, P2, P3, P4);
				break;
			default:
				break;
			}
			shipImageView.setX(ship.getShipLocation().x * scale); 		// Sets the updated ShipImageview
			shipImageView.setY(ship.getShipLocation().y * scale);
			PirateImageView1.setX(ship1.getShipLocation().x * scale); 	// Sets the updated PirateShip1Imageview
			PirateImageView1.setY(ship1.getShipLocation().y * scale);
			PirateImageView2.setX(ship2.getShipLocation().x * scale); 	// Sets the updated PirateShip2Imageview
			PirateImageView2.setY(ship2.getShipLocation().y * scale);
			ship.setPirateShip1loc(ship1.getShipLocation().x, ship1.getShipLocation().y);
			ship.setPirateShip2loc(ship2.getShipLocation().x, ship2.getShipLocation().y);
			ship4.MoveStrategy(); //use startegy 1 and 2 .execute operation 
			ship5.MoveStrategy();
		}
	});
}

//Returns the Singleton Map instance
public static MapGridSingleton getInstance() 
{
     return instance;
}

public AnchorPane getRoot() {
	return root;
}

}
