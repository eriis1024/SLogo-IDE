package BooleanOperations;
import java.util.List;

public class Less implements BooleanOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double a = args[0];
		double b = args[1];
		return (a < b) ? 1:0;
	}
}