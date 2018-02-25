import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class SlogoImageWindow {
	
	private BorderPane myRoot;
	private Node myNode;

	// load a welcome image
	// everytime we hear the user press enter or the enterbutton. check for an
	// update

	public SlogoImageWindow(BorderPane root) {
		myRoot = root;
		myNode = loadWelcomeScreen();
		myRoot.setCenter(this.getImageWindow());
	}

	private Node loadWelcomeScreen() {
		Image welcomeImage = new Image("resources/welcomeScreen.png");
		ImageView iv1 = new ImageView();
		iv1.setImage(welcomeImage);
		iv1.setFitWidth(500);
		iv1.setPreserveRatio(true);
		return iv1;
	}

	// PART OF INTERNAL API
	public void updateScreen() {
		// TODO: instead of making iv2 a new image view, set iv2 = to a call to the
		// backend external API that returns the current Image View
		ImageView iv2 = new ImageView();
		myNode = iv2;
		myRoot.setCenter(this.getImageWindow());
	}

	public Node getImageWindow() {
		return myNode;
	}
}
