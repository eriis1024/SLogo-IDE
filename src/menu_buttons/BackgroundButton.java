package menu_buttons;

import javafx.scene.paint.Color;
import uiux.MenuBarController;


public class BackgroundButton extends ColorButtons {

	public BackgroundButton(MenuBarController passedController) {
		super("Change background color", Color.WHITE, passedController);
	}
	
	@Override
	public void action() {
		super.action();
		super.controller.findBackgroundColor(colorChosen);
	}
}
