package uiux;


import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class MenuBar extends HBox{
	private BackgroundButton backgroundColor = new BackgroundButton();
	private PenButton penColor = new PenButton();
	
	private Region[] buttons = {
			new HelpButton(),
			backgroundColor,
			penColor,
			new LanguageButton()
	};
	
	private MenuBarController controller = new MenuBarController(backgroundColor, penColor);
	private static final int PADDING = 15;
	private static final int MIN_SIZE = 55;
	private static final int MAX_SIZE = 80;
	
	public MenuBar() {
		super(PADDING);
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
