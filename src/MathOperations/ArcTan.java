package MathOperations;

public class ArcTan implements MathOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double degrees = args[0];
		double atan = Math.atan(Math.toRadians(degrees));
		return Math.toDegrees(atan);
	}
}
