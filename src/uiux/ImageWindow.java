package uiux;
import java.util.ArrayList;
import java.util.List;
import Movers.Mover;
import Movers.Turtle;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Screen;

public class ImageWindow implements ImageWindowInterface {

	private Node myNode;
	protected Mover myTurtle;
	protected Pane myRoot;
	protected List<Line> myLines = new ArrayList<Line>();

	
	// constructor
	public ImageWindow() {
		myNode = loadWelcomeScreen();
	}

	private Node loadWelcomeScreen() {
		myRoot = new Pane();
		setSizeAndTurtle();
		updateTurtleLocation(myTurtle);
		return myRoot;
	}
	
	//don't let turtle out of screen bounds
	//setXY, turtle at 0,0, input commands relative to that
	//test all other commands
	//clear lines, determine final window size and where (0,0) is, change this for Home, CS...
	//add methods to mover interface
	
	// part of the API
	@Override
	public Node updateScreen() {
		updateTurtleLocation(myTurtle);
		return myNode;
	}

	// part of the API
	@Override
	public Node getImageWindow() {
		return myNode;
	}
	
	private void updateTurtleLocation(Mover turtle) {
		double x = turtle.getImageView().getX();
		double y = turtle.getImageView().getY();
		turtle.getImageView().setX(turtle.getX());
		turtle.getImageView().setY(turtle.getY());
		if (x == 0 && y == 0) {
			addTurtleInScene(turtle);
			return;
		}
		if (turtle.getPenStatus() == true) {
			addLineInScene(myTurtle, x, y);
		}
		if (turtle.getClear() == true) {
			turtle.setClear(false);
			removeLines();
		}
	}

	private void addTurtleInScene(Mover turtle){
		if(!myRoot.getChildren().contains(turtle.getImageView())) {
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
		System.out.println(primaryScreenBounds.getWidth()/2);
		myRoot.setPrefHeight(primaryScreenBounds.getHeight()/2);
		myRoot.getStyleClass().add("box");
		myTurtle = new Turtle(320, 240, "images/turtle.png");
	}
	
	// Part of the API
	@Override
	public Mover getTurtle() {
		return myTurtle;
	}
	
	private void removeLines() {
		myLines = myTurtle.getLines();
		for (int i = 0; i < myLines.size(); i++) {
			myRoot.getChildren().remove(myLines.get(i));
		}
	}
}
