package parsing;

import java.util.*;

public abstract class Calculator {
	
	public double[] toCalc;

	public Calculator(double[] input){
		toCalc = input;
	}
	
	public abstract double getResult();
	
}
