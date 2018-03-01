package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class Left implements CommandInterface {
	private Mover myMover;
	
	public Left(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) { 
		double angle = args[0];
		myMover.setAngle(myMover.getAngle() - angle);
		return angle;
	}
}