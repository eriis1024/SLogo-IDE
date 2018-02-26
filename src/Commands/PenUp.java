package Commands;
import javafx.scene.layout.Pane;
import Movers.Mover;

public class PenUp implements TurtleCommand {
	private Mover myMover;
	
	public PenUp(Mover turtle) {
		myMover = turtle;
	}
	
	@Override
	public double executeCommand(Integer[] args) {
		myMover.setPenStatus(false);
		return 0;
	}
}