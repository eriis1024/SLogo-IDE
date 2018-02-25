package BooleanOperations;

import java.util.List;

public class Not implements BooleanOperation {

	@Override
	public double executeCommand(List<Integer> args) {
		double a = args.get(0);
		return (a == 0) ? 1:0;
	}
}

