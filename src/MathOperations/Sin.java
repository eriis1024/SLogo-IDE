package MathOperations;

import Command.CommandInterface;

public class Sin implements CommandInterface {

	@Override
	public double executeCommand(Integer[] args) {
		double degrees = args[0];
		double sin = Math.sin(Math.toRadians(degrees));
		return Math.toDegrees(sin);
	}
}
