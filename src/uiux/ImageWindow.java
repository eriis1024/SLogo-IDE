package uiux;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class ImageWindow {
	
	//private BorderPane myRoot;
	private Node myNode;

	// load a welcome image
	// everytime we hear the user press enter or the enterbutton. check for an
	// update

	public ImageWindow() {
		//myRoot = root;
		myNode = loadWelcomeScreen();
		//myRoot.setCenter(this.getImageWindow());
	}

	private Node loadWelcomeScreen() {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		Image welcomeImage = new Image("resources/welcomeScreen.png");
		ImageView iv1 = new ImageView();
		iv1.setImage(welcomeImage);
		iv1.setFitWidth(primaryScreenBounds.getWidth()/2);
		iv1.setPreserveRatio(true);
		VBox result = new VBox();
		result.getChildren().add(iv1);
		
		result.setPrefWidth(primaryScreenBounds.getWidth()/2);
		return result;
	}

	// PART OF INTERNAL API
	public Node updateScreen() {
		// TODO: instead of making iv2 a new image view, set iv2 = to a call to the
		// backend external API that returns the current Image View
		ImageView iv2 = new ImageView();
		myNode = iv2;
		//myRoot.setCenter(this.getImageWindow());
		return myNode;
	}

	public Node getImageWindow() {
		//updateScreen();
		return myNode;
	}
}
