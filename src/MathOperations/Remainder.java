package MathOperations;

public class Remainder implements MathOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double x = args[0];
		double y = args[1];
		return x % y;
	}
}