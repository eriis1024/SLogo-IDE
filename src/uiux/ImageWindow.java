package uiux;
import Movers.Mover;
import Movers.Turtle;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
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
		return myRoot;
	}
	
	public Node updateScreen() {
		System.out.println("HERE:" + myTurtle.getX());
		updateTurtleLocation(myTurtle);
		return myNode;
	}


	public Node getImageWindow() {
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
