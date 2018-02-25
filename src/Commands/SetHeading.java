package Commands;
import Movers.Mover;

public class SetHeading implements TurtleCommand {
private Mover myTurtle;
	
	public SetHeading(Mover turtle) {
		myTurtle = turtle;
	}

	@Override
	public void executeCommand(Integer[] args) {
		myTurtle.setAngle(myTurtle.getAngle() + args[0]);
	}
}
