package Commands;

import Movers.Mover;
import javafx.scene.layout.Pane;

public class Home implements TurtleCommand {
	private Mover myMover;
	
	public Home(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(Integer[] args) { 
		myMover.setCoords(500/2, 500/2);
	}
}