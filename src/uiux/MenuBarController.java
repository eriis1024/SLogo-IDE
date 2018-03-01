package uiux;

import javafx.scene.paint.Color;

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
		
		
	}

	public void findBackgroundColor(Color colorChosen) {
		// TODO Auto-generated method stub
		
	}
	

}
