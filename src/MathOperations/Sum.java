package MathOperations;

import Command.CommandInterface;

public class Sum implements CommandInterface {

	@Override
	public double executeCommand(Integer[] args) {
		double x = args[0];
		double y = args[1];
		return x + y;
	}
}


