import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Turtle {
	private Rectangle myTurtle;
	private Path myPath;


	public Shape create(Color color, int x, int y, double angle) {
		myTurtle = new Rectangle();
		myTurtle.setWidth(15);
		myTurtle.setHeight(15);
		myTurtle.setFill(color);
		myTurtle.setRotate(angle);
		
		return myTurtle;	
	}
	
	public Path createPath(Color color, double d, double e) {
		myPath = new Path();
		myPath.setStroke(color);
		myPath.setStrokeWidth(2);
		myPath.getElements().add(new MoveTo(0.0f, 0.0f));
		return myPath;
	}

	public void move(double moveX, double moveY) { //change random vars
		myPath.getElements().add(new MoveTo(myTurtle.getX(), myTurtle.getY()));
		myTurtle.setTranslateX(myTurtle.getX() + moveX);
		myTurtle.setTranslateY(myTurtle.getY() + moveY);
		myPath.getElements().add(new LineTo(moveX, moveY));
	}

	public double getX() {
		return myTurtle.getX();
	}

	public double getY() {
		return myTurtle.getY();
	}

	public double getRotate() {
		return myTurtle.getRotate();
	}

	public void setX(double d) {
		myTurtle.setTranslateX(d);
	}

	public void setY(double d) {
		myTurtle.setTranslateY(d);
	}

	public void setRotate(double angle) {
		myTurtle.setRotate(angle);
	}
}
