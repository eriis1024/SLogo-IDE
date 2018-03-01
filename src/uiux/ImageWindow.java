package uiux;
import java.util.ArrayList;
import java.util.List;
import Movers.Mover;
import Movers.Turtle;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Screen;

public class ImageWindow implements ImageWindowInterface {

	private Node myNode;
	private Mover myTurtle;
	private Pane myRoot;
	private Rectangle2D primaryScreenBounds;
	private List<Line> myLines = new ArrayList<Line>();
	
	// constructor
	public ImageWindow() {
		myNode = loadWelcomeScreen();
	}

	private Node loadWelcomeScreen() {
		myRoot = new Pane();
		setSizeAndTurtle();
		System.out.println(myRoot.getHeight());
		updateTurtleLocation(myTurtle);
		return myRoot;
	}
	
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
	
	public void setBackgroundColor(Color color) {
		String colorString = String.format("#%02X%02X%02X",
				(int)(color.getRed()*255.0),
				(int)(color.getGreen()*255.0),
				(int)(color.getBlue()*255.0));
		myRoot.setStyle("-fx-background-color: "+colorString);
	}
	
	public void setPenColor(Color color) {
		myTurtle.setPenColor(color);
	}
	
	public void setNewTurtleImage(ImageView newImage) {
		myTurtle.setNewImage(newImage);
		updateTurtleLocation(myTurtle);
	}
	
	private void updateTurtleLocation(Mover turtle) {
		double x = turtle.getImageView().getX();
		double y = turtle.getImageView().getY();
		if (x == 0 && y == 0) {
			addTurtleInScene(turtle);
			return;
		}
		setMoverBounds(myTurtle);
		if (turtle.getPenStatus() == true) {
			addLineInScene(myTurtle, x, y);
		}
		if (turtle.getClear() == true) {
			turtle.setClear(false);
			removeLines();
		}
		turtle.getImageView().setX(turtle.getX());
		turtle.getImageView().setY(turtle.getY());
	}

	private void addTurtleInScene(Mover turtle){
		if(!myRoot.getChildren().contains(turtle.getImageView())) {
			turtle.getImageView().setX(turtle.getX());
			turtle.getImageView().setY(turtle.getY());
			myRoot.getChildren().add(turtle.getImageView());
		}
	}

	private void addLineInScene(Mover turtle, double x, double y) {
		Line l = turtle.drawLine(x, y, turtle.getX(), turtle.getY());
		myRoot.getChildren().add(l);
	}

	private void setSizeAndTurtle() {
		primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		myRoot.setPrefWidth(primaryScreenBounds.getWidth()/2);
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
	
	private void setMoverBounds(Mover turtle) {
		if (turtle.getY() < 0) {
			turtle.setCoords(turtle.getX(), 0 + 5);
		} else if (turtle.getY() > myRoot.getHeight()) {
			turtle.setCoords(turtle.getX(), myRoot.getHeight() - Mover.MOVER_SIZE);
		} else if (turtle.getX() < 0) {
			turtle.setCoords(0 + 5, turtle.getY());
		} else if (turtle.getX() > myRoot.getWidth()) {
			turtle.setCoords(myRoot.getWidth() - Mover.MOVER_SIZE, turtle.getY());
		}
	}
}