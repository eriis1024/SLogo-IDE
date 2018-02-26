import javafx.application.Application;
import javafx.stage.Stage;

public class MySlogoApp extends Application{
	
	public static final String TITLE = "Slogo Team 5 App";
	
	
	@Override
	public void start(Stage stage) {
		// back end place holder
		SlogoModel model = new SlogoModel();
		// front end 
		SlogoView display = new SlogoView(model);

        stage.setTitle(TITLE);
        stage.setScene(display.getScene());
        stage.show();
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
