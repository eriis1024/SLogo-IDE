package uiux;
import Commands.Forward;
import Commands.SetHeading;
import Commands.TurtleCommand;
import Movers.Mover;
import Movers.Turtle;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Screen;

public class ImageWindow {

	private Node myNode;
	protected Mover myTurtle;
	protected Pane myRoot;

	public ImageWindow() {
		myNode = loadWelcomeScreen();
	}

	private Node loadWelcomeScreen() {
		myRoot = new Pane();
		
		setSizeAndTurtle();
		
		updateTurtleLocation(myTurtle);
		
		TextField commandTextField = new TextField();
		commandTextField.setMaxSize(100, 20);
		commandTextField.setPromptText("forward");
		commandTextField.setTranslateY(200);
		commandTextField.setTranslateX(200);

		TextField headingTextField = new TextField();
		headingTextField.setPromptText("heading");
		headingTextField.setMaxSize(100, 20);
		headingTextField.setTranslateY(200);
		headingTextField.setTranslateX(100);

		commandTextField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				int dist = Integer.parseInt(commandTextField.getText());
				TurtleCommand command = new Forward(myTurtle);
				Integer[] args = new Integer[1];
				args[0] = dist;
				command.executeCommand(args);
				updateTurtleLocation(myTurtle);
			}
		});

		headingTextField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				int rotate = Integer.parseInt(headingTextField.getText());
				TurtleCommand command = new SetHeading(myTurtle);
				Integer[] args = new Integer[1];
				args[0] = rotate;
				command.executeCommand(args);
			}
		});
		myRoot.getChildren().addAll(commandTextField, headingTextField);
		
		return myRoot;
	}
	
	public Node updateScreen() {
		// TODO: instead of making iv2 a new image view, set iv2 = to a call to the
		// backend external API that returns the current Image View
		
		updateTurtleLocation(myTurtle);
		
//		ImageView iv2 = new ImageView();
//		myNode = iv2;
		//myRoot.setCenter(this.getImageWindow());
		return myNode;
	}


	public Node getImageWindow() {
		//updateScreen();
		return myNode;
	}
	
	public void updateTurtleLocation(Mover turtle) {
		double x = turtle.getImageView().getX();
		double y = turtle.getImageView().getY();
		turtle.getImageView().setX(turtle.getX());
		turtle.getImageView().setY(turtle.getY());
		if (x == 0 && y == 0) {
			addTurtleInScene(turtle);
			return;
		}
		if (turtle.getPenStatus() == true){
			addLineInScene(myTurtle, x, y);
		}
	}

	private void addTurtleInScene(Mover turtle){
		if(!myRoot.getChildren().contains(turtle.getImageView())){
			turtle.getImageView().setX(turtle.getX());
			turtle.getImageView().setY(turtle.getY());
			myRoot.getChildren().add(turtle.getImageView());
		}
	}

	private void addLineInScene(Mover turtle, double x, double y){
		Line l = turtle.drawLine(x, y, turtle.getX(), turtle.getY());
		myRoot.getChildren().add(l);
	}
	
	//Sets up the size of the image window and positions the turtle in the middle,
	//also adds the styling 
	private void setSizeAndTurtle() {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		myRoot.setPrefWidth(primaryScreenBounds.getWidth()/2);
		myRoot.setPrefHeight(primaryScreenBounds.getHeight()/2);
		myRoot.getStyleClass().add("box");
		myTurtle = new Turtle((int)(myRoot.getPrefWidth()/2), (int)(myRoot.getPrefHeight()/2), "images/turtle.png");
	}

	public Mover getTurtle() {
		return myTurtle;
	}
}
