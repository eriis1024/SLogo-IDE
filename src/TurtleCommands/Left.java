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
		double angle = myMover.getAngle() - 180;
		myMover.setAngle(angle);
		return angle;
	}
}