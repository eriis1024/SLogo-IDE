package Commands;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class ShowTurtle implements TurtleCommand {
	private Mover myMover;
	
	public ShowTurtle(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(Integer[] args) {
		myMover.setImageStatus(false);
	}
}