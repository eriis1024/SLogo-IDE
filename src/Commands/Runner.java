package Commands;


//Temporary runner to test commands
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

import Movers.Mover;
import Movers.Turtle;

public class Runner extends Application {

	public static final int SIZE = 500;
	public static final Paint BACKGROUND_COLOR = Color.WHITE;
	public static final String TURTLE_IMAGE = "turtle.png";

	protected Mover myTurtle;
	private Scene myScene;
	private Pane myRoot;

	public void start (Stage primaryStage) throws Exception {
		myScene = setupScene(SIZE, SIZE, BACKGROUND_COLOR);	
		primaryStage.setScene(myScene);
		primaryStage.show();
	}

	private Scene setupScene(int width, int height, Paint background) {
		myRoot = new Pane();
		Scene scene = new Scene(myRoot, width, height, background);

		myTurtle = new Turtle(SIZE/2, SIZE/2, "images/turtle.png", myRoot);

		TextField commandTextField = new TextField();
		commandTextField.setMaxSize(100, 20);
		commandTextField.setPromptText("left");
		commandTextField.setTranslateY(400);
		commandTextField.setTranslateX(200);

		TextField headingTextField = new TextField();
		headingTextField.setPromptText("heading");
		headingTextField.setMaxSize(100, 20);
		headingTextField.setTranslateY(400);
		headingTextField.setTranslateX(100);

		commandTextField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				int dist = Integer.parseInt(commandTextField.getText());
				TurtleCommand command = new Forward(myTurtle, myRoot); //make so you don't need to specify root
				List<Integer> args = new ArrayList<Integer>();
				args.add(dist);
				command.executeCommand(args);
			}
		});

		headingTextField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				int rotate = Integer.parseInt(headingTextField.getText());
				TurtleCommand command = new ClearScreen(myTurtle, myRoot);
				List<Integer> args = new ArrayList<Integer>();
//				args.add(rotate);
				command.executeCommand(args);
			}
		});
		myRoot.getChildren().addAll(commandTextField, headingTextField);
		return scene;
	}

	/**
	 * Launches the program
	 * @param args
	 */
	public static void main (String[] args) {
		launch(args);
	}
}

