package Commands;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class Left implements TurtleCommand {
	private Mover myMover;
	
	public Left(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) { 
		double x = 0;
		double y = 0;
		double angle = myMover.getAngle() - 180;
		x = args[0]*Math.cos(Math.toRadians(angle));
		y = args[0]*Math.sin(Math.toRadians(angle));
		myMover.setCoords(myMover.getX() + x, myMover.getY() + y);
		double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return dist;
	}
}