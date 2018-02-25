package Commands;
import java.util.ArrayList;
import java.util.List;

public class InfoNode {

	private String myName; 
	private String myToken; 
	private List<InfoNode> myParameters;
	private InfoNode myNext;

	public InfoNode(String name, String type) {
		myName = name;
		myToken = type;
		myParameters = new ArrayList<>();
	}
	
	public String getName() {
		return myName;
	}
	
	public String getToken() {
		return myToken;
	}
	
	public void setNext(InfoNode next) {
		myNext = next;
	}
	
	public InfoNode next() {
		return myNext;
	}
	
	public void addParameter(InfoNode node) {
		myParameters.add(node);
	}
	
	public List<InfoNode> getParameters() {
		return myParameters;
	}
	
}
