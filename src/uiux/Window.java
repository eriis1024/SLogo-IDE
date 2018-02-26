package uiux;

import Movers.Mover;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import parsing.INPUT;
import uiux.ImageWindow;
/**
 * Compiles all the front-end components together.
 * 
 * @author Dorian
 *
 */
public class Window extends BorderPane {
	private MenuBar toolbar = new MenuBar();
	private ConsoleBox console = new ConsoleBox();
	private ImageWindow result = new ImageWindow();
	private Terminal compiler = new Terminal();
	
	/**
	 * Creates a Window class and sets the top section to be the button bar,
	 * the left section to be where the user inputs code (compiler), the bottom 
	 * section to where the user sees the output, and the center section to
	 * be where the user sees the actual image result. 
	 */
	
	public Window() {
		super();
		this.setTop(toolbar);
		this.setLeft(compiler.getSlogoTerminal());
		this.setBottom(console);
		this.setCenter(result.getImageWindow());
		this.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					String res = compiler.getInput();
					INPUT current = new INPUT(res, result.getTurtle());
					current.inputDecoder(res);
					console.findOutput(res);
					updateScreen();
				}
			}
		});
	}
	
	private void updateScreen() {
		this.setCenter(result.updateScreen());
	}
}
