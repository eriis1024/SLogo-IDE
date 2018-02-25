package Movers;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public interface MoverInterface {
	
	public ImageView getImageView();
	
	public List<Line> getLine();
	
	public void setCoords(double x, double y);
	
	public double getX();
	
	public double getY();

}
