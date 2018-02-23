package MathOperations;
import java.util.List;

public class Sin implements MathOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double degrees = args.get(0);
		double sin = Math.sin(Math.toRadians(degrees));
		return Math.toDegrees(sin);
	}
}
