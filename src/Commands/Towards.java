package Commands;
import java.util.List;
import Movers.Mover;

public class Towards implements TurtleCommand {
private Mover myTurtle;
	
	public Towards(Mover turtle) {
		myTurtle = turtle;
	}

	@Override
	public void executeCommand(List<Integer> args) {
		double x = args.get(0);
		double y = args.get(1);
		double currX = myTurtle.getX();
		double currY = myTurtle.getY();
		double angle = Math.atan2(y - currY, x - currX);
		myTurtle.setAngle(angle);
	}
}