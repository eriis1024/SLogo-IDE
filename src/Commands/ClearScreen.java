package Commands;

import Movers.Mover;

public class ClearScreen implements TurtleCommand {
	private Mover myMover;
	
	public ClearScreen(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) { 
		double dist = Math.sqrt(Math.pow(250 - myMover.getX(), 2) + Math.pow(250 - myMover.getY(), 2));
		myMover.setCoords(320, 240);
		myMover.setClear(true);
		return dist;
	}
}