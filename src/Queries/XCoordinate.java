package Queries;
import java.util.List;
import Movers.Mover;

public class XCoordinate implements TurtleQuery {
	private Mover myMover;
	
	public XCoordinate(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(List<Integer> args) {
		System.out.println(250 - myMover.getX());
		return 250 - myMover.getX();
	}
}