package MathOperations;

public class Log implements MathOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double x = args[0];
		return Math.log(x);
	}
}
