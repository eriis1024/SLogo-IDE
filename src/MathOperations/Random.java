package MathOperations;
import java.util.List;

public class Random implements MathOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double max = args.get(0);
		return (Math.random()*(max + 1)) + 1;
	}
}