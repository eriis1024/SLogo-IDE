package parsing;
import java.util.*;

import Command.*;
import Movers.Mover;
import TurtleCommands.*;


public class INPUT {
	
	public String theInput;
	public Mover myTurtle;
	public Boolean error;

	public Map<String,Integer> variables = new HashMap<String,Integer>();
	public ArrayList<String> Command = new ArrayList<String>();
	
	public String CONSOLE;
	
	public INPUT(Mover turtle){
		myTurtle = turtle;

		BooleanCons();
	}
	
	public void inputDecoder(String input){
		
		String[] inputDivide = input.split(" ");
		
		for (int i=0;i<inputDivide.length;i++){
			Command.add(inputDivide[i]);
		}
		
		error = false;
		variables.put("PREVIOUS_ANS", 0);
		
		if ((Command.get(0).equals("#")) || (Command.size()<1)){return;}
		
		reconstruct();
		executor();
	}
	
	public ArrayList<String> BooleanOps = new ArrayList<>();
	public void BooleanCons(){
		BooleanOps.add("LESS?");
		BooleanOps.add("LESSP");
		BooleanOps.add("GREATER?");
		BooleanOps.add("GREATERP");
		BooleanOps.add("EQUAL?");
		BooleanOps.add("EQUALP");
		BooleanOps.add("NOTEQUAL?");
		BooleanOps.add("NOTEQUALP");
		BooleanOps.add("AND");
		BooleanOps.add("OR");
		
	}
	
	public void reconstruct(){
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals("MAKE") || Command.get(i).equals("SET")){
				setControl(i);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals("XCOR") || Command.get(i).equals("YCOR")){
				positionControl(i);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals("SUM")){
				sumControl(i, i+2);
			}
		}
		
		for (int i=0;i<Command.size();i++) {
			if (BooleanOps.contains(Command.get(i))){
				booleanControl(i);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals("REPEAT")){
				repeatControl(i);
			}
		}
		
	}
	
	public Map<String, Integer> getVariables(){
		return variables;
	}
	
	public String getConsole(){
		return CONSOLE;
	}
	
	public void executor(){
		
		if (error == true){
			return;
		}
		
		for (int i=0;i<Command.size();i++){
			System.out.print(Command.get(i)+" ");
		}
		
		for (int i=0;i<Command.size();i++){
			switch (Command.get(i)){
			
				case "FORWARD":
				case "FD":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					CommandInterface current = new Forward(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = parameter[0]+"";
					break;
				}
				
				case "BACK":
				case "BK":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					CommandInterface current = new Back(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = parameter[0]+"";
					break;
				}
				
				case "LEFT":
				case "LT":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					CommandInterface current = new Left(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = parameter[0]+"";
					break;
				}
				
				case "RIGHT":
				case "RT":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					CommandInterface current = new Right(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = parameter[0]+"";
					break;
				}
				
				case "SETHEADING":
				case "SETH":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					CommandInterface current = new SetHeading(myTurtle);
					current.executeCommand(parameter);
					double turning = Math.abs(parameter[0]-myTurtle.getAngle());
					CONSOLE = turning+"";
					break;
				}
				
				case "TOWARDS":{
					double previous = myTurtle.getAngle();
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					CommandInterface current = new SetHeading(myTurtle);
					current.executeCommand(parameter);
					double turning = Math.abs(previous-myTurtle.getAngle());
					CONSOLE = turning+"";
					break;
				}
				
				case "GOTO":
				case "SETXY":{
					Integer[] parameter = new Integer[2];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					parameter[1] = Integer.parseInt(Command.get(i + 2));
					CommandInterface current = new SetXY(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = "{"+parameter[0]+","+parameter[1]+"}";
					break;
				}
				
				case "PENDOWN":
				case "PD":{
					CommandInterface current = new PenDown(myTurtle);
					current.executeCommand(new Integer[0]);
					CONSOLE = "1";
					break;
				}
				
				case "PENUP":
				case "PU":{
					CommandInterface current = new PenUp(myTurtle);
					current.executeCommand(new Integer[0]);
					CONSOLE = "0";
					break;
				}
				
				case "SHOWTURTLE":
				case "ST":{
					CommandInterface current = new ShowTurtle(myTurtle);
					current.executeCommand(new Integer[0]);
					CONSOLE = "1";
					break;
				}
				//doesn't work
				case "HIDETURTLE":
				case "HT":{
					CommandInterface current = new HideTurtle(myTurtle);
					current.executeCommand(new Integer[0]);
					CONSOLE = "0";
					break;
				}
				//goes to wrong coords
				case "HOME":{
					double previousX = myTurtle.getX();
					double previousY = myTurtle.getY();
					CommandInterface current = new Home(myTurtle);
					current.executeCommand(new Integer[0]);
					double presentX = myTurtle.getX();
					double presentY = myTurtle.getY();
					double moving = Math.sqrt(Math.pow(presentX-previousX, 2) + Math.pow(presentY-previousY, 2));
					CONSOLE = moving+"";
					break;
				}
				//doesn't work
				case "CLEARSCREEN":
				case "CS":{
					double previousX = myTurtle.getX();
					double previousY = myTurtle.getY();
					CommandInterface current = new ClearScreen(myTurtle);
					current.executeCommand(new Integer[0]);
					double presentX = myTurtle.getX();
					double presentY = myTurtle.getY();
					double moving = Math.sqrt(Math.pow(presentX-previousX, 2) + Math.pow(presentY-previousY, 2));
					CONSOLE = moving+"";
					break;
				}
				
				case "HEADING":{
					CONSOLE = myTurtle.getAngle()+"";
				}
				
				case "PENDOWN?":
				case "PENDOWNP":{
					if (myTurtle.getPenStatus()) {CONSOLE = "1";} 
					else {CONSOLE = "0";}
				}
				
				case "SHOWING":
				case "SHOWINGP":{
					if (myTurtle.getImageStatus()) {CONSOLE = "1";} 
					else {CONSOLE = "0";}
				}
				
			}
		}	
	}
	
	public void positionControl(int position){
		
		if (Command.get(position).equals("XCOR")){
			Command.set(position, (int)myTurtle.getX()+"");
			CONSOLE = myTurtle.getX()+"";
		} else {
			Command.set(position, (int)myTurtle.getY()+"");
			CONSOLE = myTurtle.getY()+"";
		}
		
	}
	
	public void booleanControl(int position){
		
		ArrayList<String> toCheck = new ArrayList<String>();
		for (int i=position;i<position+3;i++){
			toCheck.add(Command.get(i));
		}
		
		for (int i=0;i<toCheck.size();i++){
			System.out.print(toCheck.get(i)+" ");
		}
		
		boolean Checked = booleanCheck(toCheck);
		
		if (error == true){return;}
		
		if (Checked == true){
			for (int i=position;i<position+2;i++){
				Command.remove(position);
				Command.set(position, 1+"");
				CONSOLE = 1+"";
			}
		} else {
			for (int i=position;i<position+1;i++){
				Command.remove(position);
				Command.set(position, 0+"");
				CONSOLE = 0+"";
			}
		}
		
	}
	
	public boolean booleanCheck(ArrayList<String> toBoolean){
		
		switch (toBoolean.get(0)){
		
			case "LESS?":
			case "LESSP":{
				return Double.parseDouble(toBoolean.get(1)) < Double.parseDouble(toBoolean.get(2));
			}
			
			case "GREATER?":
			case "GREATERP":{
				return Double.parseDouble(toBoolean.get(1)) > Double.parseDouble(toBoolean.get(2));
			}
			
			case "EQUAL?":
			case "EQUALP":{
				return Double.parseDouble(toBoolean.get(1)) == Double.parseDouble(toBoolean.get(2));
			}
			
			case "NOTEQUAL?":
			case "NOTEQUALP":{
				return !(Double.parseDouble(toBoolean.get(1)) == Double.parseDouble(toBoolean.get(2)));
			}
			
			case "AND":{
				return (!toBoolean.get(1).equals("0")) && (!toBoolean.get(2).equals("0"));
			}
			
			case "OR":{
				return (!toBoolean.get(1).equals("0")) || (!toBoolean.get(2).equals("0"));
			}
		
		}
		
		return true;

	}
	
	public void sumControl(int position1, int position2){
		
		ArrayList<String> toCheck = new ArrayList<String>();
		for (int i=position1;i<=position2;i++){
			toCheck.add(Command.get(i));
		}
		
		int summed = sumCheck(toCheck);
		
		if (error == true){return;}
		
		for (int i=position1+1;i<=position2;i++){
			Command.remove(position1+1);
		}
		Command.set(position1, summed+"");
		
		CONSOLE = summed+"";
		variables.replace("PREVIOUS_ANS", summed);
		
	}
	
	public int sumCheck(ArrayList<String> toSum){
		
		int total = 0;
		for (int i=1;i<toSum.size();i++){
			total += Integer.parseInt(toSum.get(i));
		}
		return total;	
	}
	
	public void setControl(int position){
		
		if (variables.containsKey(Command.get(position+1))){
			variables.replace(Command.get(position+1), Integer.parseInt(Command.get(position+2)));
		} else {
			variables.put(Command.get(position+1), Integer.parseInt(Command.get(position+2)));
		}
		
	}
	
	public void repeatControl(int position){
		
		int ending = 0;
		for (int i=position+2;i<Command.size();i++){
			if (Command.get(i).equals("]")){
				ending = i;
				break;
			}
		}
		
		String toRepeat = "";
		for (int i=position+3;i<ending;i++){
			toRepeat += Command.get(i);
			toRepeat += "";
		}
		
		for (int i=0;i<Integer.parseInt(Command.get(position+1));i++){
			inputDecoder(toRepeat);
		}
		
		
		
	}
	
}
