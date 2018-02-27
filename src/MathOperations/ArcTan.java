package MathOperations;

import Command.CommandInterface;

public class ArcTan implements CommandInterface {

	@Override
	public double executeCommand(Integer[] args) {
		double degrees = args[0];
		double atan = Math.atan(Math.toRadians(degrees));
		return Math.toDegrees(atan);
	}
}
