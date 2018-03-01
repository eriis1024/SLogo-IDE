package uiux;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class BackgroundButton extends ColorPicker {
	private Color backgroundColor;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BackgroundButton() {
		super();
		super.getStyleClass().add("toolbutton");
		this.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				action();
			}
        });
	}
	
	private void action() {
		backgroundColor = super.getValue();
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}
}
