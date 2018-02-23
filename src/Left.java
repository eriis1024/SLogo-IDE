import Movers.Mover;
import javafx.scene.layout.Pane;

public class Left implements TurtleCommand {
	private Mover myMover;
	
	public Left(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(double dist) { 
		double x = 0;
		double y = 0;
		double angle = myMover.getAngle() - 180;
		x = dist*Math.cos(Math.toRadians(angle));
		y = dist*Math.sin(Math.toRadians(angle));
		myMover.setCoords(myMover.getX() + x, myMover.getY() + y);
	}
}