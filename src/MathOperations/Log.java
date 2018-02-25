package MathOperations;
import java.util.List;

public class Log implements MathOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double x = args.get(0);
		return Math.log(x);
	}
}