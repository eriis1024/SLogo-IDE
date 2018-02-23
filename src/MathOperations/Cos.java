package MathOperations;
import java.util.List;

public class Cos implements MathOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double degrees = args.get(0);
		double cos = Math.cos(Math.toRadians(degrees));
		return Math.toDegrees(cos);
	}
}
