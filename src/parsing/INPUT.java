package parsing;
import java.util.*;

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
					Forward.executeCommand(Command.get(i + 1));
				}
				
				case "bd":{
					Back.executeCommand(Command.get(i + 1));
				}
				
				case "lt":{
					Left.executeCommand(Command.get(i + 1));
				}
				
				case "rt":{
					Right.executeCommand(Command.get(i + 1));
				}
			
			}
		}
		
	}
	
	public boolean booleanControl(ArrayList<String> toBoolean){
		
		if (toBoolean.get(1).equals("greater?")){
			return Integer.parseInt(toBoolean.get(2))>Integer.parseInt(toBoolean.get(2));
		} else {
			return Integer.parseInt(toBoolean.get(2))<Integer.parseInt(toBoolean.get(2));
		}

	}
	
	public int sumControl(ArrayList<String> toSum){
		
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
	
	
	
}
