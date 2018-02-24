package uiux;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class MenuBar extends HBox{
	private ToolButton[] buttons = {
			new SaveButton(),
			new SettingsButton(),
			new LanguageButton()
	};
	
	public MenuBar() {
		//TODO : Changes these numbers to variables and give them names
		super(10);
	    this.setPadding(new Insets(15, 12, 15, 12));
	    this.setSpacing(10);
	    
	    for(ToolButton button : buttons) {
	    	this.getChildren().add(button);
	    }
	    
	    this.getStyleClass().add("toolbar");
	}
}
