package uiux;


import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class MenuBar extends HBox{
	private MenuBarController controller;
	private BackgroundButton backgroundColor;
	private PenButton penColor;
	
//	private Region[] buttons = {
//			new HelpButton(),
//			backgroundColor,
//			penColor,
//			new LanguageButton()
//	};
	
	private static final int PADDING = 15;
	private static final int MIN_SIZE = 55;
	private static final int MAX_SIZE = 80;
	
	public MenuBar(MenuBarController passedController) {
		super(PADDING);
		controller = passedController;
		controller.test();
		penColor = new PenButton(controller);
		backgroundColor = new BackgroundButton(controller);
		
		
		
		Region[] buttons = {
				new HelpButton(),
				backgroundColor,
				penColor,
				new LanguageButton()
		};
		
	    for(Region button : buttons) {
	    	button.setMinSize(MIN_SIZE, MIN_SIZE);
	    	button.setMaxSize(MAX_SIZE, MAX_SIZE);
	    	this.getChildren().add(button);
	    }
	    
	    this.getStyleClass().add("toolbar");
	}
	
	public Color getBackgroundColor() {
		return controller.getBackgroundColor();
	}
	
	public Color getPenColor() {
		return controller.getPenColor();
	}
}
