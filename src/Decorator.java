import java.awt.Point;

import javafx.stage.Stage;

public abstract class Decorator implements DecoratorInterface 			//creates an abstract decorator class and implements interface
{
    private DecoratorInterface ship;
     
    // standard constructors
    @Override
    public void goWest(Stage oceanStage,Point P1,Point P2,Point P3,Point P4)
    {
        ship.goWest(oceanStage, P4, P4, P4, P4);
    }
    @Override
    public void goSouth(Stage oceanStage,Point P1,Point P2,Point P3,Point P4) 
    {
    	ship.goSouth(oceanStage, P4, P4, P4, P4);
    }
    @Override
    public void goNorth(Stage oceanStage,Point P1,Point P2,Point P3,Point P4)
    {
    	ship.goNorth(oceanStage, P4, P4, P4, P4);
    }
    @Override
    public void goEast(Stage oceanStage,Point P1,Point P2,Point P3,Point P4)
    {
    	
    	ship.goEast(oceanStage, P4, P4, P4, P4);
    }
}
