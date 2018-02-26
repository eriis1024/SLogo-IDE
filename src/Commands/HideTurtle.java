package Commands;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class HideTurtle implements TurtleCommand {
	private Mover myMover;
	
	public HideTurtle(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		myMover.setImageStatus(false);
		return 0;
	}
}