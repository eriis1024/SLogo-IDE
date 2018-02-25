package Commands;
import java.util.List;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class ShowTurtle implements TurtleCommand {
	private Mover myMover;
	
	public ShowTurtle(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(List<Integer> args) {
		myMover.removeImage();
	}
}