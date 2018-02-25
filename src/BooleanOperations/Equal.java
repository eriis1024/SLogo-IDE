package BooleanOperations;

public class Equal implements BooleanOperation {
	
	@Override
	public double executeCommand(Integer[] args) {
		double a = args[0];
		double b = args[1];
		return (a == b) ? 1:0;
	}
}