package Movers;
import javafx.scene.Group;
import javafx.scene.layout.Pane;


public class Turtle extends Mover {  
	
    public Turtle (String imageFilePath, Pane root) {
        super(imageFilePath, root);
    }
    
    public Turtle (int x, int y, String imageFilePath, Pane root) {
        super(x, y, imageFilePath, root);
    }
}
