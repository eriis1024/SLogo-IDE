package MathOperations;
import java.util.List;

public class Sum implements MathOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double x = args.get(0);
		double y = args.get(1);
		return x + y;
	}
}


