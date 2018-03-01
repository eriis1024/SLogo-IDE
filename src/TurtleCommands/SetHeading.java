package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class SetHeading implements CommandInterface {
private Mover myMover;
	
	public SetHeading(Mover turtle) {
		myMover = turtle;
	}

	@Override
	public double executeCommand(Integer[] args) {
		double angle = args[0];
		if(angle < 0){
		   angle += 360;
		}
		myMover.setAngle(angle);
		return angle;
	}
}
