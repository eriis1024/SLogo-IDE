package menu_buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uiux.MenuBarController;

public class ImageItem extends MenuItem{
	MenuBarController controller;
	ImageView iconImage;
	
	public ImageItem(String filePath, String imageName, MenuBarController passedController) {
		super(imageName);
		setImage(filePath);
		controller = passedController;

		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				applyImage();
			}
		});
	}

	private void setImage(String path) {
		path = "../mover-icons/" + path;
		Image icon = new Image(getClass().getResourceAsStream(path));
		iconImage = new ImageView(icon);
		super.setGraphic(iconImage);
	}
	
	private void applyImage() {
		
	}
}
