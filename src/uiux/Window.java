package uiux;

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
	private ConsoleBoxInterface console = new ConsoleBox();
	private ImageWindowInterface result = new ImageWindow();
	private TerminalInterface compiler = new Terminal();
	private INPUT current = new INPUT(result.getTurtle());
	
	
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
		this.setBottom(console.getConsole());
		this.setCenter(result.getImageWindow());
		this.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					String res = compiler.getInput();
					if(res.length() == 0) {
						res = null;
					}
					try {
						
						res = res.toUpperCase();
						current.inputDecoder(res);
						console.findOutput(current.getConsole());
						updateScreen();
					}
					catch (NullPointerException e){
						//THERE IS NOTHING TO DO IN THE CATCH BECAUSE THIS IMPLIES
						//THE USER DID NOT PUT ANYTHING INTO THE ACTUAL COMPILER
						//THEREFORE THERE IS NO ERROR
					}
					
				}
			}
		});
	}
	
	private void updateScreen() {
		this.setCenter(result.updateScreen());
	}
}
