package Driver;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import uiux.Window;

public class Main extends Application{
	private static final String TITLE = "SLogo IDE";

	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Window screen = new Window();
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		primaryStage.setX(primaryScreenBounds.getMinX());
		primaryStage.setY(primaryScreenBounds.getMinY());
		primaryStage.setWidth(primaryScreenBounds.getWidth());
		primaryStage.setHeight(primaryScreenBounds.getHeight());
		
		Scene scene = new Scene(screen);
		scene.getStylesheets().add("styleSheet.css");
		
		primaryStage.setScene(scene);
		primaryStage.setTitle(TITLE);

		primaryStage.show();
	}

}
