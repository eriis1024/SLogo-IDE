package MathOperations;

public class Random implements MathOperation {

	@Override
	public double executeCommand(Integer[] args) {
		double max = args[0];
		return (Math.random()*(max + 1)) + 1;
	}
}