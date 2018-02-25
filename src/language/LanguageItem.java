package language;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class LanguageItem extends MenuItem{
	
	public LanguageItem(String lang, String path) {
		super(lang);
		setImage(path);
		
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				changeLang();
			}
		});
	}
	
	private void setImage(String path) {
		path = "../flag-icons" + path;
		Image icon = new Image(getClass().getResourceAsStream(path));
		ImageView iconImage =  new ImageView(icon);
		super.setGraphic(iconImage);
	}
	
	protected abstract void changeLang();
	
	
}
