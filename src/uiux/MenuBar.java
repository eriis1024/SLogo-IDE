package uiux;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;

public class MenuBar extends TilePane{
	private Region[] buttons = {
			new SaveButton(),
			new SettingsButton(),
			new LanguageButton()
	};
	
	private static final int MAX_SIZE = 50;
	private static final int PADDING = 10;
	
	public MenuBar() {
//		super(Orientation.HORIZONTAL);
//		super.setPadding(new Insets(20, 10, 20, 0)); 
//		super.setHgap(10);
//		super.setVgap(8);
	    for(Region button : buttons) {
//	    	button.setMaxSize(MAX_SIZE, MAX_SIZE);
//	    	button.setPrefSize(MAX_SIZE, MAX_SIZE);
	    	this.getChildren().add(button);
	    }
	    
	    this.getStyleClass().add("toolbar");
	}
}
