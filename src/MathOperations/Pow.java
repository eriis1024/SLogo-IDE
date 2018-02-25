package MathOperations;

public class Pow implements MathOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double base = args[0];
		double exp = args[1];
		return Math.pow(base, exp);
	}
}
