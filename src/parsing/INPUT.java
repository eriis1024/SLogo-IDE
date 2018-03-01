package parsing;

import java.util.*;

import Command.*;
import Movers.Mover;
import TurtleCommands.*;
import resources.languages.*;


public class INPUT {

	public Mover myTurtle;
	public Boolean error;
	
	public Bundle currentLang;

	public Map<String,Integer> variables = new HashMap<String,Integer>();
	public ArrayList<String> Command = new ArrayList<String>();
	
	public String CONSOLE;
	
	public INPUT(Mover turtle){
		myTurtle = turtle;
		BooleanCons();
		currentLang = new EnglishBundle("English");
	}
	
	public void setLanguage(String s){
		
		switch (s){
			
			case "Chinese":{
				currentLang = new ChineseBundle(s);
				break;
			}
			
			case "English":{
				currentLang = new EnglishBundle(s);
				break;
			}
			
			case "French":{
				currentLang = new FrenchBundle(s);
				break;
			}
			
			case "German":{
				currentLang = new GermanBundle(s);
				break;
			}
			
			case "Italian":{
				currentLang = new ItalianBundle(s);
				break;
			}
			
			case "Portuguese":{
				currentLang = new PortugueseBundle(s);
				break;
			}
			
			case "Russian":{
				currentLang = new RussianBundle(s);	
				break;
			}
			
			case "Spanish":{
				currentLang = new SpanishBundle(s);
				break;
			}
		
		}
		
	}
	
	public void inputDecoder(String input){
		CONSOLE = null;
		Command.clear();
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
			if (Command.get(i).equals(currentLang.MakeVariable)){
				setControl(i);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals(currentLang.XCoordinate) || Command.get(i).equals(currentLang.YCoordinate)){
				positionControl(i);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals(currentLang.Sum)){
				sumControl(i, i+2);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals(currentLang.Not)){
				notControl(i);
			}
		}
		
		for (int i=0;i<Command.size();i++) {
			if (BooleanOps.contains(Command.get(i))){
				booleanControl(i);
			}
		}
		
		for (int i=0;i<Command.size();i++){
			if (Command.get(i).equals(currentLang.Repeat)){
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
			
			if (Command.get(i).equals("SHOWVARS")) {
				CONSOLE = variables.keySet().toString();
				break;
			}
			
			else if((currentLang.Forward).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//if (Command.get(i).equals(currentLang.Forward)){
				System.out.println("FD COMMAND");
				Integer[] parameter = new Integer[1];
				parameter[0] = Integer.parseInt(Command.get(i + 1));
				CommandInterface current = new Forward(myTurtle);
				current.executeCommand(parameter);
				CONSOLE = parameter[0]+"";
				break;
			} 
			else if ((currentLang.Backward).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.Backward)){
				Integer[] parameter = new Integer[1];
				parameter[0] = Integer.parseInt(Command.get(i + 1));
				CommandInterface current = new Back(myTurtle);
				current.executeCommand(parameter);
				CONSOLE = parameter[0]+"";
				break;
			} 
			else if ((currentLang.Left).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.Left)){
				Integer[] parameter = new Integer[1];
				parameter[0] = Integer.parseInt(Command.get(i + 1));
				CommandInterface current = new Left(myTurtle);
				current.executeCommand(parameter);
				CONSOLE = parameter[0]+"";
				break;
			} 
			else if ((currentLang.Right).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.Right)){
				Integer[] parameter = new Integer[1];
				parameter[0] = Integer.parseInt(Command.get(i + 1));
				CommandInterface current = new Right(myTurtle);
				current.executeCommand(parameter);
				CONSOLE = parameter[0]+"";
				break;
			} 
			else if ((currentLang.SetHeading).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.SetHeading)){
				Integer[] parameter = new Integer[1];
				parameter[0] = Integer.parseInt(Command.get(i + 1));
				CommandInterface current = new SetHeading(myTurtle);
				current.executeCommand(parameter);
				double turning = Math.abs(parameter[0]-myTurtle.getAngle());
				CONSOLE = turning+"";
				break;
			} 
			else if ((currentLang.SetPosition).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.SetPosition)){
				Integer[] parameter = new Integer[2];
				parameter[0] = Integer.parseInt(Command.get(i + 1));
				parameter[1] = Integer.parseInt(Command.get(i + 2));
				CommandInterface current = new SetXY(myTurtle);
				current.executeCommand(parameter);
				CONSOLE = "{"+parameter[0]+","+parameter[1]+"}";
				break;
			} 
			else if ((currentLang.PenDown).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.PenDown)){
				CommandInterface current = new PenDown(myTurtle);
				current.executeCommand(new Integer[0]);
				CONSOLE = "1";
				break;
			} 
			else if ((currentLang.PenUp).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.PenUp)){
				CommandInterface current = new PenUp(myTurtle);
				current.executeCommand(new Integer[0]);
				CONSOLE = "0";
				break;
			} 
			else if ((currentLang.ShowTurtle).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.ShowTurtle)){
				CommandInterface current = new ShowTurtle(myTurtle);
				current.executeCommand(new Integer[0]);
				CONSOLE = "1";
				break;
			} 
			else if ((currentLang.HideTurtle).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.HideTurtle)){
				CommandInterface current = new HideTurtle(myTurtle);
				current.executeCommand(new Integer[0]);
				CONSOLE = "0";
				break;
			} 
			else if ((currentLang.Home).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.Home)){
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
			else if ((currentLang.ClearScreen).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.ClearScreen)){
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
			else if ((currentLang.Heading).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.Heading)){
				CONSOLE = myTurtle.getAngle()+"";
			} 
			else if ((currentLang.IsPenDown).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.IsPenDown)){
				if (myTurtle.getPenStatus()) {CONSOLE = "1";} 
				else {CONSOLE = "0";}
			} 
			else if ((currentLang.IsShowing).toUpperCase().contains(Command.get(i).toUpperCase())) {
			//else if (Command.get(i).equals(currentLang.IsShowing)){
				if (myTurtle.getImageStatus()) {CONSOLE = "1";} 
				else {CONSOLE = "0";}
			}
		}	
	}
	
	public void notControl(int position){
		
		if (Command.get(position + 1).equals("1")){
			Command.remove(position);
			Command.set(position, "0");
			CONSOLE = "0";
		} else {
			Command.remove(position);
			Command.set(position, "1");
			CONSOLE = "1";
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
		
		if (toBoolean.get(0).equals(currentLang.LessThan)){
			return Double.parseDouble(toBoolean.get(1)) < Double.parseDouble(toBoolean.get(2));
		} else if (toBoolean.get(0).equals(currentLang.GreaterThan)){
			return Double.parseDouble(toBoolean.get(1)) > Double.parseDouble(toBoolean.get(2));
		} else if (toBoolean.get(0).equals(currentLang.Equal)){
			return Double.parseDouble(toBoolean.get(1)) == Double.parseDouble(toBoolean.get(2));
		} else if (toBoolean.get(0).equals(currentLang.NotEqual)){
			return !(Double.parseDouble(toBoolean.get(1)) == Double.parseDouble(toBoolean.get(2)));
		} else if (toBoolean.get(0).equals(currentLang.And)){
			return (!toBoolean.get(1).equals("0")) && (!toBoolean.get(2).equals("0"));
		} else if (toBoolean.get(0).equals(currentLang.Or)){
			return (!toBoolean.get(1).equals("0")) || (!toBoolean.get(2).equals("0"));
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
