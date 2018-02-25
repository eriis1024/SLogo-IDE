package uiux;

import javafx.scene.layout.BorderPane;
/**
 * Compiles all the front-end components together.
 * 
 * @author Dorian
 *
 */
public class Window extends BorderPane{
	private MenuBar toolbar = new MenuBar();
	private ConsoleBox console;
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
	}
}
