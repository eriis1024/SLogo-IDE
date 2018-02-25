package uiux;

import javafx.scene.layout.HBox;

public class MenuBar extends HBox{
	private ToolButton[] buttons = {
			new SaveButton(),
			new SettingsButton(),
			new LanguageButton()
	};
	
	private static final int PADDING = 10;
	
	public MenuBar() {
		super(PADDING);
	    
	    for(ToolButton button : buttons) {
	    	this.getChildren().add(button);
	    }
	    
	    this.getStyleClass().add("toolbar");
	}
}
