package MathOperations;
import java.util.List;

public class Minus implements MathOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double x = args.get(0);
		return -x;
	}
}