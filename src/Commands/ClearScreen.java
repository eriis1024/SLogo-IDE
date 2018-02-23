package Commands;

import java.util.List;
import Movers.Mover;
import javafx.scene.layout.Pane;

public class ClearScreen implements TurtleCommand {
	private Mover myMover;
	
	public ClearScreen(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(List<Integer> args) { 
		myMover.setCoords(500/2, 500/2);
		myMover.removeLines();
	}
}