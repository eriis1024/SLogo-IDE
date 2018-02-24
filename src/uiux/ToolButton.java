package uiux;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ToolButton extends Button{
	protected int prefSize = 50;
	
	public ToolButton(String labelName, String path) {
		
		
		super(labelName);
		
		Image icon = new Image(getClass().getResourceAsStream(path));
		super.setGraphic(new ImageView(icon));
		
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
