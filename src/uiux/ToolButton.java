package uiux;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class ToolButton extends Button{
	protected int prefSize = 50;
	
	public ToolButton(String label) {
		super(label);
		this.setPrefSize(prefSize, prefSize);
		this.setOnAction(new EventHandler<ActionEvent>()
				{	
					@Override
					public void handle(ActionEvent arg0) {
						action();
					}
				});
	}
	
	public abstract void action();
}
