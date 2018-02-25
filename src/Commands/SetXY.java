package Commands;
import Movers.Mover;
import javafx.scene.layout.Pane;

public class SetXY implements TurtleCommand {
	private Mover myMover;
	
	public SetXY(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(Integer[] args) { 
		double x = args[0];
		double y = args[0];
		myMover.setCoords(x, y);
	}
}