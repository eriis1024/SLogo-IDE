package Commands;

import java.util.List;
import Movers.Mover;
import javafx.scene.layout.Pane;

public class SetXY implements TurtleCommand {
	private Mover myMover;
	
	public SetXY(Mover turtle, Pane root) {
		myMover = turtle;
	}
	
	@Override
	public void executeCommand(List<Integer> args) { 
		double x = args.get(0);
		double y = args.get(1);
		myMover.setCoords(x, y);
	}
}