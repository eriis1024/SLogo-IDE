package uiux;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;

public abstract class ColorButtons extends ColorPicker{
	protected Color colorChosen;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ColorButtons(String label) {
		super();
		super.getStyleClass().add("toolbutton");
		setToolTip(label);
		this.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				action();
			}

			
        });
	}
	
	private void setToolTip(String label) {
		Tooltip hover = new Tooltip(label);
		Tooltip.install(this, hover);
	}
	
	private void action() {
		colorChosen = super.getValue();
	}
	
	public Color getColor() {
		return colorChosen;
	}
}
