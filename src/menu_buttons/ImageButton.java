package menu_buttons;

import java.io.File;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import uiux.MenuBarController;

public class ImageButton extends MenuButton{
	MenuBarController controller;
	
	public ImageButton(MenuBarController passedController) {
		super("Images");
		super.getStyleClass().add("toolbutton");
		
		controller = passedController;
		for(String name : options) {
			MenuItem imageChoice = new MenuItem(name);
			this.getItems().add(imageChoice);
		}
	}
}
