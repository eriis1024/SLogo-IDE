package MathOperations;

public class Cos implements MathOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double degrees = args[0];
		double cos = Math.cos(Math.toRadians(degrees));
		return Math.toDegrees(cos);
	}
}
