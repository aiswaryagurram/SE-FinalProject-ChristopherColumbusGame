import java.awt.Point;

import javafx.stage.Stage;

public interface DecoratorInterface 				//Creates an Interface for Decorator design pattern
{
	void goWest(Stage oceanStage,Point P1,Point P2,Point P3,Point P4);
	void goSouth(Stage oceanStage,Point P1,Point P2,Point P3,Point P4);
	void goNorth(Stage oceanStage,Point P1,Point P2,Point P3,Point P4);
	void goEast(Stage oceanStage,Point P1,Point P2,Point P3,Point P4);
}
