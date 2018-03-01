package uiux;

import javafx.scene.Node;

public interface ConsoleBoxInterface {

	/**
	 * Method to add return values from the back end to the observable list of
	 * entries that the console displays. Part of the Front End External API.
	 */
	public void findOutput(String s);

	/**
	 * Returns the console object. Called from the window class to add the console
	 * to the application.
	 * 
	 * @return
	 */
	public Node getConsole();

}
