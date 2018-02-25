package Commands;
import java.util.List;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class PenDown implements TurtleCommand {
	private Mover myMover;
	
	public PenDown(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(List<Integer> args) {
		myMover.PenStatus(true);
	}
}