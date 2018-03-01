package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class Right implements CommandInterface {
	private Mover myMover;
	
	public Right(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) { 
		double angle = args[0];
		myMover.setAngle(myMover.getAngle() + angle);
		return angle;
	}
}