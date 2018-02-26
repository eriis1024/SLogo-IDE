package uiux;


import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class MenuBar extends HBox{
	private Region[] buttons = {
			new HelpButton(),
			new SaveButton(),
			new SettingsButton(),
			new LanguageButton()
	};
	
	private static final int PADDING = 10;
	private static final int MIN_SIZE = 60;
	
	public MenuBar() {
		super(PADDING);
	    for(Region button : buttons) {
	    	button.setMinSize(MIN_SIZE, MIN_SIZE);
	    	this.getChildren().add(button);
	    }
	    
	    this.getStyleClass().add("toolbar");
	}
}
