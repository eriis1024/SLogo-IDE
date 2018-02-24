package uiux;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ToolButton extends Button{
	protected int prefSize = 50;
	
	public ToolButton(String path) {
		super();
		setImage(path);
		
		
		this.setPrefSize(prefSize, prefSize);
		this.setOnAction(new EventHandler<ActionEvent>()
				{	
					@Override
					public void handle(ActionEvent arg0) {
						action();
					}
				});
		
		this.setStyle("-fx-background-color: slateblue;");
		//this.getStyleClass().add("toolbutton");
	}
	
	private void setImage(String path) {
		Image icon = new Image(getClass().getResourceAsStream(path));
		ImageView iconImage =  new ImageView(icon);
		iconImage.setFitHeight(prefSize);
		iconImage.setFitWidth(prefSize);
		super.setGraphic(iconImage);
	}
	
	public abstract void action();
}
