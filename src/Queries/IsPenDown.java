package Queries;
import java.util.List;
import Movers.Mover;

public class IsPenDown implements TurtleQuery {
	private Mover myMover;
	
	public IsPenDown(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(List<Integer> args) {
		if (myMover.getPenStatus() == true) {
			return 1;
		} else {
			return 0;
		}
	}
}