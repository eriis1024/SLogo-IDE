package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class Towards implements CommandInterface {
private Mover myTurtle;
	
	public Towards(Mover turtle) {
		myTurtle = turtle;
	}

	@Override
	public double executeCommand(Integer[] args) {
		double x = args[0];
		double y = args[1];
		double currX = myTurtle.getX();
		double currY = myTurtle.getY();
		double angle = Math.atan2(y - currY, x - currX);
		myTurtle.setAngle(Math.toDegrees(angle));
		return Math.toDegrees(angle);
	}
}