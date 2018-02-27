package Commands;
import Movers.Mover;

public class ShowTurtle implements TurtleCommand {
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