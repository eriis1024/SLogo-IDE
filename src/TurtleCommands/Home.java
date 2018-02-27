package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class Home implements CommandInterface {
	private Mover myMover;
	
	public Home(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) { 
		double dist = Math.sqrt(Math.pow(250 - myMover.getX(), 2) + Math.pow(250 - myMover.getY(), 2));
		myMover.setCoords(320, 240);
		return dist;
	}
}