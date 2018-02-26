package parsing;
import java.util.*;
import java.util.regex.Pattern;

import Commands.*;
import Movers.Mover;


public class INPUT {
	
	public String theInput;
	public Mover myTurtle;

	public Map<String,Integer> variables = new HashMap<String,Integer>();
	public ArrayList<String> Command = new ArrayList<String>();
	
	public INPUT(String inputs, Mover turtle){
		theInput = inputs;
		myTurtle = turtle;
	}
	
	public void inputDecoder(String input){
		
		String[] inputDivide = input.split(" ");
		
		for (int i=0;i<inputDivide.length;i++){
			Command.add(inputDivide[i]);
		}
		reconstruct();
		executor();
	}
	
	public void reconstruct(){
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals("*")){
				booleanControl(i);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals("sum")){
				sumControl(i, i+2);
			}
		}
	}
	
	public Map getVariavles(){
		return variables;
	}
	
	public void executor(){
		
		for (int i=0;i<Command.size();i++){
			switch (Command.get(i)){
			
				case "fd":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new Forward(myTurtle);
					current.executeCommand(parameter);
					break;
				}
				
				case "bd":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new Back(myTurtle);
					current.executeCommand(parameter);
					break;
				}
				
				case "lt":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new Left(myTurtle);
					current.executeCommand(parameter);
					break;
				}
				
				case "rt":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new Right(myTurtle);
					current.executeCommand(parameter);
					break;
				}
				
				case "SetXY":{
					Integer[] parameter = new Integer[2];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					parameter[1] = Integer.parseInt(Command.get(i + 2));
					TurtleCommand current = new SetXY(myTurtle);
					current.executeCommand(parameter);
					break;
				}
			}
		}	
	}
	
	public void booleanControl(int position){
		
		ArrayList<String> toCheck = new ArrayList<String>();
		for (int i=position;i<=position+3;i++){
			toCheck.add(Command.get(i));
		}
		
		boolean Checked = booleanCheck(toCheck);
		
		if (Checked == true){
			for (int i=position;i<=position+3;i++){
				Command.remove(position);
			}
		} else {
			for (int i=position;i<position+5;i++){
				Command.remove(position - 1);
			}
		}
		
	}
	
	public boolean booleanCheck(ArrayList<String> toBoolean){
		
		if (toBoolean.get(1).equals("greater?")){
			return Integer.parseInt(toBoolean.get(2))>Integer.parseInt(toBoolean.get(3));
		} else {
			return Integer.parseInt(toBoolean.get(2))<Integer.parseInt(toBoolean.get(3));
		}

	}
	
	public void sumControl(int position1, int position2){
		
		ArrayList<String> toCheck = new ArrayList<String>();
		for (int i=position1;i<=position2;i++){
			toCheck.add(Command.get(i));
		}
		
		int summed = sumCheck(toCheck);
		
		for (int i=position1+1;i<=position2;i++){
			Command.remove(position1+1);
		}
		Command.set(position1, summed+"");
		
	}
	
	public int sumCheck(ArrayList<String> toSum){
		
		int total = 0;
		for (int i=1;i<toSum.size();i++){
			total += Integer.parseInt(toSum.get(i));
		}
		return total;	
	}

	
}
