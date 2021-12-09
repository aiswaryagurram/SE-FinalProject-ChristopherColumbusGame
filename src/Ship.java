import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class Ship extends Observable                //Ships acts as observable

{
	abstract ImageView loadShipImage(AnchorPane root);       //Defines the abstract loadshipimage method
}

