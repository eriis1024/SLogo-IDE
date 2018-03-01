package uiux;

import javafx.scene.paint.Color;

public class MenuBarController {
	private BackgroundButton backgroundColor;
	private PenButton penColor;
	
	public MenuBarController(BackgroundButton bColor, PenButton pColor) {
		backgroundColor = bColor;
		penColor = pColor;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor.getColor();
	}
	
	public Color getPenColor() {
		return penColor.getColor();
	}
	
}
