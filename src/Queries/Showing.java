package Queries;
import java.util.List;
import Movers.Mover;

public class Showing implements TurtleQuery {
	private Mover myMover;
	
	public Showing(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(List<Integer> args) {
		System.out.println(myMover.getImageStatus());
		if (myMover.getImageStatus() == true) {
			return 1;
		} else {
			return 0;
		}
	}
}