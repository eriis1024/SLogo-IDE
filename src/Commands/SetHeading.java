package Commands;
import java.util.List;
import Movers.Mover;

public class SetHeading implements TurtleCommand {
private Mover myTurtle;
	
	public SetHeading(Mover turtle) {
		myTurtle = turtle;
	}

	@Override
	public void executeCommand(List<Integer> args) {
		myTurtle.setAngle(args.get(0));
	}
}
