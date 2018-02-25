package uiux;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class ConsoleBox extends ListView<String>{
	private ObservableList<String> myPrevCommands = FXCollections.observableArrayList();;
	private String currentOutput = "";
	
	public ConsoleBox(){
		super();
		this.setItems(myPrevCommands);
	}
	
	public void findOutput(String systemOutput) {
		currentOutput = systemOutput;
		updateList();
	}
	
	private void updateList() {
		myPrevCommands.add(currentOutput);
	}
}
