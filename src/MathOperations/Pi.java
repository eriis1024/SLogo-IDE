package MathOperations;
import java.util.List;

public class Pi implements MathOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		return Math.PI;
	}
}
