package MathOperations;

import Command.CommandInterface;

public class Pi implements CommandInterface {

	@Override
	public double executeCommand(Integer[] args) {
		return Math.PI;
	}
}
