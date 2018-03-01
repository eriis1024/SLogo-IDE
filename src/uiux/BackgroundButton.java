package uiux;

import javafx.scene.paint.Color;


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
