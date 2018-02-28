package MathOperations;

import Command.CommandInterface;

public class Log implements CommandInterface {

	@Override
	public double executeCommand(Integer[] args) {
		double x = args[0];
		return Math.log(x);
	}
}
