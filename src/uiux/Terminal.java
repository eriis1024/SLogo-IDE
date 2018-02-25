package uiux;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

/*
 * 	Class to represent slogo terminal.
 *  This is an area of the program with a textbox that the user can type commands into.
 *	The program will list the previous commands for the user to see. 
 */
public class Terminal{
	
	private Node myNode;
	private TextField myTextField;
	private ObservableList<String> myPrevCommands;
	
	private String input;

	/*
	 * Sets the value of myNode to a node with a text field, enter button, and list
	 * of previously entered commands.
	 */
	public Terminal() {
		myNode = makeTurtleTerminal();
	}

	/*
	 * Returns the node representing the slogo terminal. Called in the SlogoView
	 * class, when the view is initialized.
	 */
	// INTERNAL API
	public Node getSlogoTerminal() {
		return myNode;
	}

	/*
	 * adds elements of the terminal to a Vbox.
	 */
	private Node makeTurtleTerminal() {
		VBox result = new VBox();
		result.getChildren().add(makeHistoryTable());
		result.getChildren().add(makeInputField(40, event -> passTextInput()));
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		result.setPrefWidth(primaryScreenBounds.getWidth()/2);
		//Creates an enter button -- still debating on whether to use
		//result.getChildren().add(makeButton("Enter", event -> passTextInput()));
		
		return result;
		
	}
	
	/*
	 * Makes list of previously entered commands.
	 */
	private ListView<String> makeHistoryTable() {
		ListView<String> list = new ListView<>();
		myPrevCommands = FXCollections.observableArrayList();
		list.setItems(myPrevCommands);
		return list;
	}
	
	/*
	 * Makes input text field.
	 */
	// webbrowser example code
	// make text field for input
	private TextField makeInputField(int width, EventHandler<ActionEvent> handler) {
		TextField result = new TextField();
		result.setOnAction(handler);
		myTextField = result;
		return result;
	}
	
	/*
	 * Returns the text entered by the user currently in the textbox
	 */
	// PART OF THE EXTERNAL API
	public String passTextInput() {
		String retString = myTextField.getText();
		myPrevCommands.add(retString);
		myTextField.clear();
		input = retString;
		return retString;
	}
	
	
	public String getInput() {
		return input;
	}
	
	/*
	 * makes enter button.
	 */
	// makeButton function code taken from webbrowser example
	// makes a button using either an image or a label
	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}
	
}
