package MathOperations;

import Command.CommandInterface;

public class Random implements CommandInterface {

	@Override
	public double executeCommand(Integer[] args) {
		double max = args[0];
		return (Math.random()*(max + 1)) + 1;
	}
}