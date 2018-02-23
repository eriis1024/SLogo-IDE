package MathOperations;
import java.util.List;

public class ArcTan {

	public double executeCommand(List<Integer> args) {
		double degrees = args.get(0);
		double atan = Math.atan(Math.toRadians(degrees));
		return Math.toDegrees(atan);
	}
}
