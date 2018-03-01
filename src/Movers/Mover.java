package Movers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Mover implements MoverInterface {

	public static int MOVER_SIZE = 20;
	public static int PEN_WIDTH = 2;
	private ImageView myImage;
	private double xInd;
	private double yInd;
	protected boolean penCheck; 
	protected boolean imageCheck;
	protected boolean clearCheck;
	private List<Line> myLines;
	private Color penColor = Color.BLACK; //default

	public Mover(double x, double y, String imageFilePath) {
		setMover(x, y, imageFilePath);
	}

	public void setCoords(double x, double y) {
		xInd = x;
		yInd = y;
	}

	public double getX(){
		return xInd;
	}

	public double getY() {
		return yInd;
	}

	public void setAngle(double angle) {
		myImage.setRotate(myImage.getRotate() + angle);
	}

	public double getAngle() {
		return myImage.getRotate();
	}
	
	public void setPenStatus(boolean pen) {
		penCheck = pen;
	}

	public boolean getPenStatus() {
		return penCheck;
	}

	public void setImageStatus(boolean image) {
		myImage.setVisible(image);
		imageCheck = image;
	}

	public boolean getImageStatus() {
		return imageCheck;
	}

	public ImageView getImageView() {
		return myImage;
	}
	
	public void setImageView(String imageFilePath) {
		File file = new File(imageFilePath);
		myImage = new ImageView(file.toURI().toString());
	}

	public Line drawLine(double x, double y, double x1, double y1) {
		Line newLine = new Line();
		newLine.setStartX(x + 10);
		newLine.setEndX(x1 + 10);
		newLine.setStartY(y + 10);
		newLine.setEndY(y1 + 10);
		newLine.setStrokeWidth(PEN_WIDTH);
		newLine.setStroke(penColor);
		myLines.add(newLine);
		return newLine;
	}

	public List<Line> getLines() {
		return myLines;
	}
	
	public boolean getClear() {
		return clearCheck;	
	}
	
	public void setClear(boolean bool) {
		clearCheck = bool;	
	}
	
	public void setPenColor(Color color) {
		penColor = color;
	}
	
	public void setNewImage(ImageView newImage) {
		myImage = newImage;
		myImage.setFitWidth(MOVER_SIZE);
		myImage.setFitHeight(MOVER_SIZE);
	}

	private void setMover(double x, double y, String imageFilePath){
		xInd = x;
		yInd = y;
		File file = new File(imageFilePath);
		myImage = new ImageView(file.toURI().toString());
		myImage.setFitWidth(MOVER_SIZE);
		myImage.setFitHeight(MOVER_SIZE);
		myLines = new ArrayList<Line>();
		penCheck =  true;
		imageCheck = true;   
	}
}