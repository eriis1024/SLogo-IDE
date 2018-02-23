package BooleanOperations;

import java.util.List;

public class And implements BooleanOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double a = args.get(0);
		double b = args.get(1);
		return (a != 0 && b != 0) ? 1:0;
	}
}
