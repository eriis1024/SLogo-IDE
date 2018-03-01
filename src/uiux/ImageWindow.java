package uiux;
import java.util.ArrayList;
import java.util.List;
import Movers.Mover;
import Movers.Turtle;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
	
	//setXY, turtle at 0,0, input commands relative to that
	//test all other commands
	//set boundaries for turtle (wrap screen)
	
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
		System.out.print(color);
		String colorString = String.format("#%02X%02X%02X",
				(int)(color.getRed()*255.0),
				(int)(color.getGreen()*255.0),
				(int)(color.getBlue()*255.0));
		myRoot.setStyle("-fx-background-color: "+colorString);
		System.out.println(colorString);
		
	}
	
	private void updateTurtleLocation(Mover turtle) {
//		Rectangle background = new Rectangle(myRoot.getWidth(),myRoot.getHeight(),Color.BLUE);
//		myRoot.getChildren().add(background);
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

	private void addLineInScene(Mover turtle, double x, double y){
		Line l = turtle.drawLine(x, y, turtle.getX(), turtle.getY());
		myRoot.getChildren().add(l);
	}
	

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
	//get rid of magic numbers, account for image size as well
	private void setMoverBounds(Mover turtle) {
		if (turtle.getY() < 0) {
			turtle.setCoords(turtle.getX(), 0 + 5);
		} else if (turtle.getY() > 460) {
			turtle.setCoords(turtle.getX(), 460);
		} else if (turtle.getX() < 0) {
			System.out.println("here");
			turtle.setCoords(0 + 5, turtle.getY());
		} else if (turtle.getX() > 640) {
			turtle.setCoords(620, turtle.getY());
		}
	}
}
