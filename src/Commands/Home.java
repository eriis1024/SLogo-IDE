package Commands;

import java.util.List;
import Movers.Mover;
import javafx.scene.layout.Pane;

public class Home implements TurtleCommand {
	private Mover myMover;
	
	public Home(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(List<Integer> args) { 
		myMover.setCoords(500/2, 500/2);
	}
}