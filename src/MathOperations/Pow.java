package MathOperations;
import java.util.List;

public class Pow implements MathOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double base = args.get(0);
		double exp = args.get(1);
		return Math.pow(base, exp);
	}
}
