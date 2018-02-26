package Commands;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class Right implements TurtleCommand {
	private Mover myMover;
	
	public Right(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(Integer[] args) { 
		double x = 0;
		double y = 0;
		double angle = myMover.getAngle();
		x = args[0]*Math.cos(Math.toRadians(angle));
		y = args[0]*Math.sin(Math.toRadians(angle));
		myMover.setCoords(myMover.getX() + x, myMover.getY() + y);
	}
}