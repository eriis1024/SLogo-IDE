package Commands;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class PenDown implements TurtleCommand {
	private Mover myMover;
	
	public PenDown(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(Integer[] args) {
		myMover.setPenStatus(true);
	}
}