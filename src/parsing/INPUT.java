package parsing;
import java.util.*;

import Commands.*;

public class INPUT {
	
	public String theInput;
	public ArrayList<String> Command = new ArrayList<String>();
	
	public void inputDecoder(String input){
		
		String[] inputDivide = input.split(" ");
		
		for (int i=0;i<input.length();i++){
			Command.add(inputDivide[i]);
		}
		
	}
	
	public void executor(){
		
		for (int i=0;i<Command.size();i++){
			switch (Command.get(i)){
			
				case "fd":{
					int[] parameter = new int[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					Forward.executeCommand(parameter);
				}
				
				case "bd":{
					int[] parameter = new int[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					Back.executeCommand(Command.get(i + 1));
				}
				
				case "lt":{
					int[] parameter = new int[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					Left.executeCommand(Command.get(i + 1));
				}
				
				case "rt":{
					int[] parameter = new int[1];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					Right.executeCommand(Command.get(i + 1));
				}
				
				case "SetXY":{
					int[] parameter = new int[2];
					parameter[0] = Integer.parseInt(Command.get(i + 1));
					parameter[1] = Integer.parseInt(Command.get(i + 2));
					SetXY.executeCommand(parameter);
				}
				
				
			
			}
		}
		
	}
	
	public void booleanControl(int position){
		
		ArrayList<String> toCheck = new ArrayList<String>();
		for (int i=position;i<position+3;i++){
			toCheck.add(Command.get(i));
		}
		
		boolean Checked = booleanCheck(toCheck);
		
		if (Checked == true){
			for (int i=position;i<position+3;i++){
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
		for (int i=position1;i<position2;i++){
			toCheck.add(Command.get(i));
		}
		
		int summed = sumCheck(toCheck);
		
		for (int i=position1+1;i<position2 - 1;i++){
			Command.remove(position1 + 1);
		}
		Command.set(position1+1, summed+"");
		
	}
	
	public int sumCheck(ArrayList<String> toSum){
		
		for (int i=0;i<toSum.size();i++){
			if (toSum.get(i).equals("sum")){
				toSum.set(i, "0");
			}
		}
		
		int total = 0;
		for (int i=0;i<toSum.size();i++){
			total += Integer.parseInt(toSum.get(i));
		}
		
		return total;
		
	}
	
	public int 
	
}
