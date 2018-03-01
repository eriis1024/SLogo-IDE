package uiux;

import javafx.scene.Node;

public interface TerminalInterface {

	/*
	 * Returns the node representing the slogo terminal. Called in the Window class,
	 * when the view is initialized. Part of the Front End Internal API.
	 */
	public Node getSlogoTerminal();

	/*
	 * Returns a string of the text entered by the user that was passed to the
	 * terminal class form the textbox. Part of the Front End External API.
	 */
	public String getInput();

}
