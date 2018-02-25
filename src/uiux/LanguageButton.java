package uiux;

import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import language.English;
import language.French;
import language.German;
import language.Italian;
import language.LanguageItem;
import language.Portuguese;
import language.Russian;
import language.Spanish;

public class LanguageButton extends MenuButton{
	
	private static final String PATH = "../button-images/languages.png";
	private LanguageItem[] langOptions = {
			new English(),
			new French(),
			new German(),
			new Italian(),
			new Portuguese(),
			new Russian(),
			new Spanish()
	};
	
	public LanguageButton() {
		super("Languages");
		setIcon();
		this.getStyleClass().add("toolbutton");
		for(LanguageItem lang : langOptions) {
			this.getItems().add(lang);
		}
	}
	
	private void setIcon() {
		Image icon = new Image(getClass().getResourceAsStream(PATH));
		ImageView iconImage =  new ImageView(icon);
		super.setGraphic(iconImage);
	}
	
	
}
