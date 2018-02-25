package BooleanOperations;

public class Not implements BooleanOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double a = args[0];
		return (a == 0) ? 1:0;
	}
}

