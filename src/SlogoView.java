import java.awt.Dimension;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import uiux.ImageWindow;

public class SlogoView {
	// constants
    public static final Dimension DEFAULT_SIZE = new Dimension(800, 600);
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    //public static final String STYLESHEET = "default.css";
    //public static final String BLANK = " ";

    // scene, needed to report back to Application
    private Scene myScene;
    // information area
    //private Label myStatus;
    // navigation
    //private TextField myURLDisplay;
    //private Button myBackButton;
    //private Button myNextButton;
    //private Button myHomeButton;
    // favorites
    //private ComboBox<String> myFavorites;
    // get strings from resource file
    private ResourceBundle myResources;
    // the data
    private SlogoModel myModel;
    
    public SlogoView(SlogoModel model) {
    	myModel = model;
    	//myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE); //+ language);
    	BorderPane root = new BorderPane();
    	// TODO: eventually change this from method to new class
    	
    	ImageWindow myCenterElement = new ImageWindow(root);
    	SlogoTerminal myLeftElement = new SlogoTerminal(root, myCenterElement);
  
    	
    	myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
        // TODO: uncomment to activate CSS styling/ create own css file
        // myScene.getStylesheets().add(DEFAULT_RESOURCE_PACKAGE + STYLESHEET);
	}
    
	public Scene getScene() {
		return myScene;
	}
		
}
