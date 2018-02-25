
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import Commands.Forward;
import Commands.SetHeading;
import Commands.TurtleCommand;
import Movers.Mover;
import Movers.Turtle;



//Need to: figure out how to call commands after parsing, make turtle not depend on root, add complex commands
//have turtle class have get/sets for coordinates, line, and image, actually add the components to scene in GUI class
//Return the correct values in each class
//check for errors

public class TurtleGUI {

	private Mover myTurtle;
	protected Pane myRoot;


	public Scene setupScene(int width, int height, Paint background) {
		myRoot = new Pane();
		Scene scene = new Scene(myRoot, width, height, background);
		myTurtle = new Turtle(250, 250, "images/turtle.png");
		updateTurtleLocation(myTurtle);


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


		commandTextField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				int dist = Integer.parseInt(commandTextField.getText());
			
				TurtleCommand command = new Forward(myTurtle);
				Integer[] args = new Integer[1];
				args[0] = dist;
				command.executeCommand(args);
				
				
				updateTurtleLocation(myTurtle);
			}
		});


		headingTextField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				int rotate = Integer.parseInt(headingTextField.getText());
				TurtleCommand command = new SetHeading(myTurtle);
				Integer[] args = new Integer[1];
				args[0] = rotate;
				command.executeCommand(args);
			}
		});
//
//		queryTextField.setOnKeyPressed(event -> {
//			if (event.getCode() == KeyCode.ENTER) {
//				TurtleQuery command = new Showing(myTurtle);
//				List<Integer> args = new ArrayList<Integer>();
//				args.add(1);
//				command.executeCommand(args);
//			}
//		});

		myRoot.getChildren().addAll(commandTextField, headingTextField, queryTextField);
		return scene;
	}

	public void updateTurtleLocation(Mover turtle) {
		double x = turtle.getImageView().getX();
		double y = turtle.getImageView().getY();
		turtle.getImageView().setX(turtle.getX());
		turtle.getImageView().setY(turtle.getY());
		if (x == 0 && y == 0) {
			addTurtleInScene(turtle);
			return;
		}
		if (turtle.getPenStatus() == true){
			addLineInScene(myTurtle, x, y);
		}
	}

	private void addTurtleInScene(Mover turtle){
		if(!myRoot.getChildren().contains(turtle.getImageView())){
			turtle.getImageView().setX(turtle.getX());
			turtle.getImageView().setY(turtle.getY());
			myRoot.getChildren().add(turtle.getImageView());
		}
	}

	private void addLineInScene(Mover turtle, double x, double y){
		Line l = turtle.drawLine(x, y, turtle.getX(), turtle.getY());
		myRoot.getChildren().add(l);
	}
}

