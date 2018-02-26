package Commands;
import Movers.Mover;

public class SetXY implements TurtleCommand {
	private Mover myMover;
	
	public SetXY(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) { 
		double x = args[0];
		double y = args[0];
		double dist = Math.sqrt(Math.pow(x - myMover.getX(), 2) + Math.pow(y - myMover.getY(), 2));
		myMover.setCoords(x, y);
		return dist;
	}
}