package MathOperations;
import java.util.List;

public class Product implements MathOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double x = args.get(0);
		double y = args.get(1);
		return x*y;
	}
}