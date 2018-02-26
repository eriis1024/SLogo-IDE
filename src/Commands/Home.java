package Commands;

import Movers.Mover;
import javafx.scene.layout.Pane;

public class Home implements TurtleCommand {
	private Mover myMover;
	
	public Home(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) { 
		double dist = Math.sqrt(Math.pow(250 - myMover.getX(), 2) + Math.pow(250 - myMover.getY(), 2));
		myMover.setCoords(250, 250);
		return dist;
	}
}