import Movers.Mover;

public class SetHeading implements TurtleCommand {
private Mover myTurtle;
	
	public SetHeading(Mover turtle) {
		myTurtle = turtle;
	}

	@Override
	public void executeCommand(double angle) {
		myTurtle.setAngle(angle);
	}
}
