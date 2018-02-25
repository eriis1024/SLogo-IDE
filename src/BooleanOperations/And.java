package BooleanOperations;


public class And implements BooleanOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double a = args[0];
		double b = args[1];
		return (a != 0 && b != 0) ? 1:0;
	}
}
