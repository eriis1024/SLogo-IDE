package Movers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

//make this and front end non-dependent on each other (get rid of root in this class, add methods in 
public class Mover implements MoverInterface {
	private ImageView myImage;
	private Line myLine;
	private Pane myRoot;
	private boolean imageCheck = true;
	private boolean penCheck = true;
	private double lineX = 250;
	private double lineY = 250;
	private List<Line> myLines;

	public Mover(String imageFilePath, Pane root) {
		init(0, 0, imageFilePath, root);
	}

	public Mover(double x, double y, String imageFilePath, Pane root) {
		init(x, y, imageFilePath, root);
	}

	public void setCoords(double x, double y) {
		double currX = lineX;
		double currY = lineY;
		if (penCheck == true) {
			myLine = drawLine(currX, currY, x, y);
			myRoot.getChildren().add(myLine);
		}
		myImage.setTranslateX(x);
		myImage.setTranslateY(y);
		lineX = myImage.getTranslateX();
		lineY = myImage.getTranslateY();
	}

	public double getX() {
		return myImage.getTranslateX();
	}

	public double getY() {
		return myImage.getTranslateY();
	}

	public void setAngle(double angle){
		if(angle < 0) {
			angle += 360;
		}
		myImage.setRotate(angle);
	}

	public double getAngle(){
		return myImage.getRotate();
	}

	@Override
	public ImageView getImageView(){
		return myImage;
	}

	@Override
	public List<Line> getLine(){
		return myLines;
	}

	public void PenStatus(boolean status) {
		penCheck = status;
	}
	
	public boolean getPenStatus() {
		return penCheck;
	}
	
	public void removeImage() {
		imageCheck = false;
		myRoot.getChildren().remove(myImage);
	}
	
	public void addImage() {
		imageCheck = true;
		myRoot.getChildren().add(myImage);
	}
	
	public boolean getImageStatus() {
		return imageCheck;
	}
	
	public void removeLines() {
		for (int i = 0; i < myLines.size(); i++) {
			myRoot.getChildren().remove(myLines.get(i));
		}
	}

	public Line drawLine(double x, double y, double x1, double y1){
		Line newLine = new Line();
		newLine.setStartX(x + 10);
		newLine.setEndX(x1 + 10);
		newLine.setStartY(y + 10);
		newLine.setEndY(y1 + 10);
		newLine.setFill(Color.RED);
		newLine.setStrokeWidth(2);
		myLines.add(newLine);
		return newLine;
	}

	private void init(double x, double y, String imageFilePath, Pane root) {
		myRoot = root;
		File file = new File(imageFilePath);
		myImage = new ImageView(file.toURI().toString());
		myImage.setFitWidth(20);
		myImage.setFitHeight(20);
		myImage.setTranslateX(x);
		myImage.setTranslateY(y);
		myRoot.getChildren().addAll(myImage);
		myLines = new ArrayList<Line>();
	}
}