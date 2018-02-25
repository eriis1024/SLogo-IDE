package Commands;

import java.util.List;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class Back implements TurtleCommand {
	private Mover myMover;
	
	public Back(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(List<Integer> args) { 
		double x = 0;
		double y = 0;
		double angle = myMover.getAngle() - 90;
		x = args.get(0)*Math.cos(Math.toRadians(angle));
		y = args.get(0)*Math.sin(Math.toRadians(angle));
		myMover.setCoords(myMover.getX() - x, myMover.getY() - y);
	}
}