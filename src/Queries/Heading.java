package Queries;
import Command.CommandInterface;
import Movers.Mover;

public class Heading implements CommandInterface {
	private Mover myMover;
	
	public Heading(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) { 
		return myMover.getAngle();
	}
}