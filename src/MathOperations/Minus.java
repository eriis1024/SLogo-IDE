package MathOperations;

import Command.CommandInterface;

public class Minus implements CommandInterface {

	@Override
	public double executeCommand(Integer[] args) {
		double x = args[0];
		return -x;
	}
}