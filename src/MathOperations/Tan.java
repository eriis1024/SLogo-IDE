package MathOperations;

public class Tan implements MathOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double degrees = args[0];
		double tan = Math.tan(Math.toRadians(degrees));
		return Math.toDegrees(tan);
	}
}
