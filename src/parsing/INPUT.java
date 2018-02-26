package parsing;
import java.util.*;

import Commands.*;
import Movers.Mover;


public class INPUT {
	
	public String theInput;
	public Mover myTurtle;
	
	public Boolean error;

	public Map<String,Integer> variables = new HashMap<String,Integer>();
	public ArrayList<String> Command = new ArrayList<String>();
	
	public String CONSOLE;
	
	public INPUT(String inputs, Mover turtle){
		theInput = inputs;
		myTurtle = turtle;
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
	
	public void reconstruct(){
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals("XCOR") || Command.get(i).equals("YCOR")){
				positionControl(i);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals("sum")){
				sumControl(i, i+2);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals("*")){
				booleanControl(i);
			}
		}
	}
	
	public Map<String, Integer> getVariavles(){
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
			switch (Command.get(i)){
			
				case "FORWARD":
				case "FD":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new Forward(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = parameter[0]+"";
					break;
				}
				
				case "BACK":
				case "BK":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new Back(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = parameter[0]+"";
					break;
				}
				
				case "LEFT":
				case "LT":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new Left(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = parameter[0]+"";
					break;
				}
				
				case "RIGHT":
				case "RT":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new Right(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = parameter[0]+"";
					break;
				}
				
				case "SETHEADING":
				case "SETH":{
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new SetHeading(myTurtle);
					current.executeCommand(parameter);
					double turning = Math.abs(parameter[0]-myTurtle.getAngle());
					CONSOLE = turning+"";
					break;
				}
				
				case "TOWARDS":{
					double previous = myTurtle.getAngle();
					Integer[] parameter = new Integer[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					TurtleCommand current = new SetHeading(myTurtle);
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
					TurtleCommand current = new SetXY(myTurtle);
					current.executeCommand(parameter);
					CONSOLE = "{"+parameter[0]+","+parameter[1]+"}";
					break;
				}
				
				case "PENDOWN":
				case "PD":{
					TurtleCommand current = new PenDown(myTurtle);
					current.executeCommand(new Integer[0]);
					CONSOLE = "1";
					break;
				}
				
				case "PENUP":
				case "PU":{
					TurtleCommand current = new PenUp(myTurtle);
					current.executeCommand(new Integer[0]);
					CONSOLE = "0";
					break;
				}
				
				case "SHOWTURTLE":
				case "ST":{
					TurtleCommand current = new ShowTurtle(myTurtle);
					current.executeCommand(new Integer[0]);
					CONSOLE = "1";
					break;
				}
				
				case "HIDETURTLE":
				case "HT":{
					TurtleCommand current = new HideTurtle(myTurtle);
					current.executeCommand(new Integer[0]);
					CONSOLE = "0";
					break;
				}
				
				case "HOME":{
					double previousX = myTurtle.getX();
					double previousY = myTurtle.getY();
					TurtleCommand current = new Home(myTurtle);
					current.executeCommand(new Integer[0]);
					double presentX = myTurtle.getX();
					double presentY = myTurtle.getY();
					double moving = Math.sqrt(Math.pow(presentX-previousX, 2) + Math.pow(presentY-previousY, 2));
					CONSOLE = moving+"";
					break;
				}
				
				case "CLEARSCREEN":
				case "CS":{
					double previousX = myTurtle.getX();
					double previousY = myTurtle.getY();
					TurtleCommand current = new ClearScreen(myTurtle);
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
		for (int i=position;i<=position+3;i++){
			toCheck.add(Command.get(i));
		}
		
		boolean Checked = booleanCheck(toCheck);
		
		if (error == true){return;}
		
		if (Checked == true){
			for (int i=position;i<=position+3;i++){
				Command.remove(position);
			}
		} else {
			for (int i=position;i<position+5;i++){
				Command.remove(position - 1);
			}
		}
		
		CONSOLE = Boolean.toString(Checked);
		
	}
	
	public boolean booleanCheck(ArrayList<String> toBoolean){
		
		if (toBoolean.get(1).equals("greater?")){
			return Integer.parseInt(toBoolean.get(2))>Integer.parseInt(toBoolean.get(3));
		} else if (toBoolean.get(1).equals("smaller?")){
			return Integer.parseInt(toBoolean.get(2))<Integer.parseInt(toBoolean.get(3));
		} else {
			error = true;
			CONSOLE = "Invalid comparing operation!";
			return false;
		}

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

}
