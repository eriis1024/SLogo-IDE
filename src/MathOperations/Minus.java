package MathOperations;

public class Minus implements MathOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double x = args[0];
		return -x;
	}
}