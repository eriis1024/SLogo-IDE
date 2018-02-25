package uiux;

import javafx.scene.control.Menu;
import language.German;
import language.LanguageItem;

public class LanguageButton extends ToolButton{
	
	private static final String PATH = "languages.png";
	private Menu dropdown;
	private LanguageItem[] langOptions = {
			new German()
	};
	
	public LanguageButton() {
		super(PATH);
		dropdown = new Menu();
		for(LanguageItem lang : langOptions) {
			dropdown.getItems().add(lang);
		}
	}

	@Override
	public void action() {
		dropdown.setVisible(true);
	}

}
