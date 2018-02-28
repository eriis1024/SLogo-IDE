package Queries;
import Command.CommandInterface;
import Movers.Mover;

public class XCoordinate implements CommandInterface {
	private Mover myMover;
	
	public XCoordinate(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		System.out.println(250 - myMover.getX());
		return 250 - myMover.getX();
	}
}