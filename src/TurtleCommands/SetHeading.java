package TurtleCommands;
import Command.CommandInterface;
import Movers.Mover;

public class SetHeading implements CommandInterface {
private Mover myTurtle;
	
	public SetHeading(Mover turtle) {
		myTurtle = turtle;
	}

	@Override
	public double executeCommand(Integer[] args) {
		double angle = args[0];
		if(angle < 0){
		   angle += 360;
		}
		myTurtle.setAngle(angle);
		return angle;
	}
}
