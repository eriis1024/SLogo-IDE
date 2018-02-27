package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class PenUp implements CommandInterface {
	private Mover myMover;
	
	public PenUp(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		myMover.setPenStatus(false);
		return 0;
	}
}