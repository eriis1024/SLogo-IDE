package uiux;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ListView;
import javafx.stage.Screen;

public class ConsoleBox extends ListView<String>{
	private ObservableList<String> myPrevCommands = FXCollections.observableArrayList();;
	private String currentOutput = "";
	
	public ConsoleBox(){
		super();
		this.setItems(myPrevCommands);
		this.getStyleClass().add("box");
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		this.setPrefHeight(primaryScreenBounds.getHeight()/4);
	}
	
	public void findOutput(String systemOutput) {
		currentOutput = systemOutput;
		updateList();
	}
	
	private void updateList() {
		myPrevCommands.add(currentOutput);
	}
}
