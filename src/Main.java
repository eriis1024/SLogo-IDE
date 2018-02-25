import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static final int SIZE = 500;
	public static final Paint BACKGROUND_COLOR = Color.WHITE;
	public static final String TURTLE_IMAGE = "turtle.png";
	private Scene myScene;
	private TurtleGUI turtlePane = new TurtleGUI();

	public void start (Stage primaryStage) throws Exception {
		myScene = turtlePane.setupScene(SIZE, SIZE, BACKGROUND_COLOR);	
		primaryStage.setScene(myScene);
		primaryStage.show();
	}
	

	public static void main (String[] args) {
		launch(args);
	}
}

