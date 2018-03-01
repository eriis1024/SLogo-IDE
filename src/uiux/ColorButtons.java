package uiux;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;

public abstract class ColorButtons extends ColorPicker{
	protected Color colorChosen;
	protected MenuBarController controller;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ColorButtons(String label, Color defaultColor, MenuBarController passedController) {
		super(defaultColor);
		controller = passedController;
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
	
	public void action() {
		colorChosen = super.getValue();
	}
	
	public Color getColor() {
		return colorChosen;
	}
}
