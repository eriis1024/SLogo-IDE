package uiux;


import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class MenuBar extends HBox{
	private Region[] buttons = {
			new SaveButton(),
			new SettingsButton(),
			new LanguageButton()
	};
	
	private static final int PADDING = 10;
	
	public MenuBar() {
		super(PADDING);
	    for(Region button : buttons) {
	    	this.getChildren().add(button);
	    }
	    
	    this.getStyleClass().add("toolbar");
	}
}
