package uiux;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class ConsoleBox extends ListView<String>{
	private ObservableList<String> results;
	private String currentOutput;
	
	public ConsoleBox() {
		super();
		List<String> list = new ArrayList<String>();
		results = FXCollections.observableList(list);
		results.addListener(new ListChangeListener<String>() {
			@Override
			public void onChanged(Change<? extends String> change) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	public void findOutput(String systemOutput) {
		currentOutput = systemOutput;
		
	}
	
	private void updateList() {
		results.add(currentOutput);
	}

}
