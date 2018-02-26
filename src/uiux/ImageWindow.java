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
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		myTurtle = new Turtle(200, 100, "images/turtle.png");
		updateTurtleLocation(myTurtle);
		
		myRoot.setPrefWidth(primaryScreenBounds.getWidth()/2);
		return myRoot;
	}
	
	public Node updateScreen() {
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

	public Mover getTurtle() {
		return myTurtle;
	}
}
