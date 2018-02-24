
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import java.util.ArrayList;
import java.util.List;

import Commands.Forward;
import Commands.SetHeading;
import Commands.TurtleCommand;
import Movers.Mover;
import Movers.Turtle;
import Queries.Showing;
import Queries.TurtleQuery;


public class TurtleGUI {

	private Mover myTurtle;
	private Pane myRoot;

	public Scene setupScene(int width, int height, Paint background) {
		myRoot = new Pane();
		Scene scene = new Scene(myRoot, width, height, background);
		myTurtle = new Turtle(250, 250, "images/turtle.png", myRoot);

		
		//textfields are just for testing commands
		TextField commandTextField = new TextField();
		commandTextField.setMaxSize(100, 20);
		commandTextField.setPromptText("forward");
		commandTextField.setTranslateY(400);
		commandTextField.setTranslateX(200);

		TextField headingTextField = new TextField();
		headingTextField.setPromptText("heading");
		headingTextField.setMaxSize(100, 20);
		headingTextField.setTranslateY(400);
		headingTextField.setTranslateX(100);

		TextField queryTextField = new TextField();
		queryTextField.setPromptText("query");
		queryTextField.setMaxSize(100, 20);
		queryTextField.setTranslateY(400);
		queryTextField.setTranslateX(300);

		
		//how are commands going to be called -> add call method in command interfaces?
		commandTextField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				int dist = Integer.parseInt(commandTextField.getText());
				TurtleCommand command = new Forward(myTurtle, myRoot);
				List<Integer> args = new ArrayList<Integer>();
				args.add(dist);
				command.executeCommand(args);
			}
		});

		headingTextField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				int rotate = Integer.parseInt(headingTextField.getText());
				TurtleCommand command = new SetHeading(myTurtle);
				List<Integer> args = new ArrayList<Integer>();
				args.add(rotate);
				command.executeCommand(args);
			}
		});
		
		queryTextField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				TurtleQuery command = new Showing(myTurtle);
				List<Integer> args = new ArrayList<Integer>();
				args.add(1);
				command.executeCommand(args);
			}
		});
		
		myRoot.getChildren().addAll(commandTextField, headingTextField, queryTextField);
		return scene;
	}
}

