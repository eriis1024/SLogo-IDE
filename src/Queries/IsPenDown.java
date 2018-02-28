package Queries;
import Command.CommandInterface;
import Movers.Mover;

public class IsPenDown implements CommandInterface {
	private Mover myMover;
	
	public IsPenDown(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		if (myMover.getPenStatus() == true) {
			return 1;
		} else {
			return 0;
		}
	}
}