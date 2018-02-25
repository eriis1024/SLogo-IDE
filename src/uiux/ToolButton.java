package uiux;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ToolButton extends Button{
	protected int prefSize = 30;
	
	public ToolButton(String path) {
		super();
		setImage(path);
		
		
		//this.setPrefSize(prefSize, prefSize);
		this.setOnAction(new EventHandler<ActionEvent>()
				{	
					@Override
					public void handle(ActionEvent arg0) {
						action();
					}
				});
		
		this.getStyleClass().add("toolbutton");
	}
	
	private void setImage(String path) {
		path = "../button-images/" + path;
		Image icon = new Image(getClass().getResourceAsStream(path));
		ImageView iconImage =  new ImageView(icon);
		iconImage.setFitHeight(prefSize);
		iconImage.setFitWidth(prefSize);
		super.setGraphic(iconImage);
	}
	
	protected abstract void action();
}
