package Queries;
import java.util.List;
import Movers.Mover;

public class YCoordinate implements TurtleQuery {
	private Mover myMover;
	
	public YCoordinate(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(List<Integer> args) {
		System.out.println(250 - myMover.getY());
		return 250 - myMover.getY();
		
	}
}