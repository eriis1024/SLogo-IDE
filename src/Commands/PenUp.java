package Commands;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class PenUp implements TurtleCommand {
	private Mover myMover;
	
	public PenUp(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(Integer[] args) {
		myMover.setPenStatus(false);
	}
}