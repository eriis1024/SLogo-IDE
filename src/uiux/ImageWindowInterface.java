package uiux;

import Movers.Mover;
import javafx.scene.Node;

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
	 * Returns the turlte object from the imagewindow. Called by the backend, so the
	 * turtle can be manipulated. Part of the Front End External API.
	 * 
	 * @return
	 */
	public Mover getTurtle();

}
