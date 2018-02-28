package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class PenDown implements CommandInterface {
	private Mover myMover;
	
	public PenDown(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		myMover.setPenStatus(true);
		return 1;
	}
}