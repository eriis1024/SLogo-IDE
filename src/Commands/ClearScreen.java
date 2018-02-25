package Commands;

import Movers.Mover;

public class ClearScreen implements TurtleCommand {
	private Mover myMover;
	
	public ClearScreen(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(Integer[] args) { 
		myMover.setCoords(500/2, 500/2);
		myMover.removeLines();
	}
}