package uiux;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Screen;

public class ConsoleBox implements ConsoleBoxInterface{
	private ObservableList<String> myPrevCommands = FXCollections.observableArrayList();;
	private String currentOutput = "";
	
	private Node myNode;
	
	public ConsoleBox(){
//		super();
//		this.setItems(myPrevCommands);
//		this.getStyleClass().add("box");
//		
//		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//		this.setPrefHeight(primaryScreenBounds.getHeight()/4);
		
		myNode = makeConsoleBox();
	}
	
	@Override
	public void findOutput(String systemOutput) {
		currentOutput = systemOutput;
		updateList();
	}
	
	private void updateList() {
		myPrevCommands.add(currentOutput);
	}
	
	private Node makeConsoleBox() {
		ListView<String> list = new ListView<>();
		list.setItems(myPrevCommands);
		list.getStyleClass().add("box");
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		list.setPrefHeight(primaryScreenBounds.getHeight()/4);
		return list;
	}
	
	public Node getConsole() {
		return myNode;
	}
}
