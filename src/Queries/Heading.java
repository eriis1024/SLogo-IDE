package Queries;

import java.util.List;
import Movers.Mover;

public class Heading implements TurtleQuery {
	private Mover myMover;
	
	public Heading(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(List<Integer> args) { 
		System.out.println(myMover.getAngle());
		return myMover.getAngle();
	}
}