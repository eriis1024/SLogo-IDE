package Movers;

import javafx.scene.image.ImageView;


public interface MoverInterface {
	
	public ImageView getImageView();
	
	public void setCoords(double x, double y);
	
	public double getX();
	
	public double getY();

}
