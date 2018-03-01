package uiux;

import javafx.scene.paint.Color;
import menu_buttons.BackgroundButton;
import menu_buttons.PenButton;

public class MenuBarController {
	private BackgroundButton backgroundColor;
	private PenButton penColor;
	private ImageWindowInterface imageWindow;
	
	public MenuBarController(ImageWindowInterface passedImageWindow) {
		imageWindow = passedImageWindow;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor.getColor();
	}
	
	public Color getPenColor() {
		return penColor.getColor();
	}

	public void findPenColor(Color colorChosen) {
		imageWindow.setPenColor(colorChosen);
	}

	public void findBackgroundColor(Color colorChosen) {
		imageWindow.setBackgroundColor(colorChosen);
	}

	public void test() {
		System.out.println("not null");
	}
}
