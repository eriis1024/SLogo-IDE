package Movers;

import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;


public interface MoverInterface {
	
	public void setCoords(double x, double y);
	
	public double getX();
	
	public double getY();
	
	public void setAngle(double angle);
	
	public double getAngle();
	
	public void setPenStatus(boolean pen);
	
	public boolean getPenStatus();
	
	public void setImageStatus(boolean image);
	
	public boolean getImageStatus();
	
	public Line drawLine(double x, double y, double x1, double y1);
	
	public List<Line> getLines();
	
	public boolean getClear();
	
	public ImageView getImageView();

}
