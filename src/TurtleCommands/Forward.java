package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class Forward implements CommandInterface {
	private Mover myMover;

	public Forward(Mover turtle) {
		myMover = turtle;
	}

	@Override
	public double executeCommand(Integer[] args) { 
		double x = 0;
		double y = 0;
		double angle = myMover.getAngle() - 90;
		x = args[0]*Math.cos(Math.toRadians(angle));
		y = args[0]*Math.sin(Math.toRadians(angle));
		myMover.setCoords(myMover.getX() + x, myMover.getY() + y);
		double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		System.out.println(myMover.getX());
		return dist;
	}
}
