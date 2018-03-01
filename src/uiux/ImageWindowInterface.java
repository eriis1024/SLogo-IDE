package uiux;

import Movers.Mover;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public interface ImageWindowInterface {

	/**
	 * Updates the picture of the turtle and the lines after a user enters a
	 * command. Part of the Front End External API.
	 * 
	 * @return
	 */
	public Node updateScreen();

	/**
	 * Creates the initial picture of the turtle in the center of an image. Part of
	 * the Front End External API.
	 * 
	 * @return
	 */
	public Node getImageWindow();

	/**
	 * Returns the turtle object from the ImageWindow. Called by the back end, so the
	 * turtle can be manipulated. Part of the Front End External API.
	 * 
	 * @return
	 */
	public Mover getTurtle();
	
	/**
	 * 
	 */
	public void setBackgroundColor(Color colorChosen);
	
	
	public void setPenColor(Color colorChosen);
	
	public void setNewTurtleImage(ImageView newImage);
}
