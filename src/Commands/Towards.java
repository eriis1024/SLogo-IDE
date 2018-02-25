package Commands;
import Movers.Mover;

public class Towards implements TurtleCommand {
private Mover myTurtle;
	
	public Towards(Mover turtle) {
		myTurtle = turtle;
	}

	@Override
	public void executeCommand(Integer[] args) {
		double x = args[0];
		double y = args[1];
		double currX = myTurtle.getX();
		double currY = myTurtle.getY();
		double angle = Math.atan2(y - currY, x - currX);
		myTurtle.setAngle(angle);
	}
}