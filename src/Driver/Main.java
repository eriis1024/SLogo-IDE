package Driver;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import uiux.Window;

public class Main extends Application{

	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Window screen = new Window();
		primaryStage.setScene(new Scene(screen));

		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		primaryStage.setX(primaryScreenBounds.getMinX());
		primaryStage.setY(primaryScreenBounds.getMinY());
		primaryStage.setWidth(primaryScreenBounds.getWidth());
		primaryStage.setHeight(primaryScreenBounds.getHeight());

		primaryStage.show();
	}

}
