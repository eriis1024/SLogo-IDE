package Commands;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class PenDown implements TurtleCommand {
	private Mover myMover;
	
	public PenDown(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		myMover.setPenStatus(true);
		return 1;
	}
}