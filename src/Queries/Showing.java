package Queries;
import Command.CommandInterface;
import Movers.Mover;

public class Showing implements CommandInterface {
	private Mover myMover;
	
	public Showing(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		System.out.println(myMover.getImageStatus());
		if (myMover.getImageStatus() == true) {
			return 1;
		} else {
			return 0;
		}
	}
}