package uiux;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class MenuBar extends HBox{
	private Node[] buttons = {
			new SaveButton(),
			new SettingsButton(),
			new LanguageButton()
	};
	
	private static final int SIZE = 50;
	private static final int PADDING = 10;
	
	public MenuBar() {
		super(PADDING);
	    
	    for(Node button : buttons) {
	    	button.prefHeight(SIZE);
	    	button.prefWidth(SIZE);
	    	this.getChildren().add(button);
	    }
	    
	    this.getStyleClass().add("toolbar");
	}
}
