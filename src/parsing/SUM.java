package parsing;

public class SUM extends Calculator{

	public SUM(double[] input) {
		super(input);
	}

	@Override
	public double getResult() {
		
		return toCalc[0] + toCalc[1];
		
	}

}
