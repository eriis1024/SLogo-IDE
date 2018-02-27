package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class ShowTurtle implements CommandInterface {
	private Mover myMover;
	
	public ShowTurtle(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		myMover.setImageStatus(true);
		return 1;
	}
}