package Queries;
import Command.CommandInterface;
import Movers.Mover;

public class YCoordinate implements CommandInterface {
	private Mover myMover;
	
	public YCoordinate(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		System.out.println(250 - myMover.getY());
		return 250 - myMover.getY();
		
	}
}