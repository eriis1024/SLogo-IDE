package menu_buttons;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.MenuButton;
import uiux.MenuBarController;

public class ImageButton extends MenuButton{
	private MenuBarController controller;
	private Map<String, String> imageInfo = new HashMap<>();
	
	public ImageButton(MenuBarController passedController) {
		super("Images");
		super.getStyleClass().add("toolbutton");
		super.setPrefWidth(80);
		controller = passedController;
		
		imageInfo.put("bowser.png", "Bowser");
		imageInfo.put("bowserjr.png", "Bowser Junior");
		imageInfo.put("cow.png", "Cow");
		imageInfo.put("newturtle.png", "New Turtle");
		imageInfo.put("turtle.png", "Standard Turtle");
		
		for(String key : imageInfo.keySet()) {
			ImageItem item = new ImageItem(key, imageInfo.get(key), controller);
			this.getItems().add(item);
		}
	}
}
