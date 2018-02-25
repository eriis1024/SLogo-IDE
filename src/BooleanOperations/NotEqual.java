package BooleanOperations;
import java.util.List;

public class NotEqual implements BooleanOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double a = args.get(0);
		double b = args.get(1);
		return (a != b) ? 1:0;
	}
}