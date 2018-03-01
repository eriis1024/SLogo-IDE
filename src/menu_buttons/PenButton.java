package menu_buttons;
import javafx.scene.paint.Color;
import uiux.MenuBarController;

public class PenButton extends ColorButtons{
	public PenButton(MenuBarController passedController) {
		super("Change pen color", Color.BLACK, passedController);
	}
	
	@Override
	public void action() {
		super.action();
		super.controller.findPenColor(colorChosen);

	}
}
