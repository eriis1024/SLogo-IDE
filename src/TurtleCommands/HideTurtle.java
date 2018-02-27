package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class HideTurtle implements CommandInterface {
	private Mover myMover;
	
	public HideTurtle(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		myMover.setImageStatus(false);
		return 0;
	}
}