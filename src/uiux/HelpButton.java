package uiux;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelpButton extends ToolButton{

	private static final String PATH = "help.png";

	public HelpButton() {
		super(PATH);
	}

	@Override
	protected void action() {
		try {
			Desktop.getDesktop().browse(new URI("https://www2.cs.duke.edu/courses/compsci308/spring18/assign/03_slogo/commands.php"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
	}

}
