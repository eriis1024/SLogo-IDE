package MathOperations;
import java.util.List;

public class Tan {

	public double executeCommand(List<Integer> args) {
		double degrees = args.get(0);
		double tan = Math.tan(Math.toRadians(degrees));
		return Math.toDegrees(tan);
	}
}
