package Commands;
import Movers.Mover;

public class SetHeading implements TurtleCommand {
private Mover myTurtle;
	
	public SetHeading(Mover turtle) {
		myTurtle = turtle;
	}

	@Override
	public double executeCommand(Integer[] args) {
		double angle = args[0];
		double newangle = angle % 360;
		if(newangle < 0){
		    newangle += 360;
		}
		myTurtle.setAngle(myTurtle.getAngle() + angle);
		return angle;
	}
}
