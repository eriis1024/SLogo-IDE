package uiux;
import javafx.scene.paint.Color;

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
