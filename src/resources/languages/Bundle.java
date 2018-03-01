package resources.languages;

import java.util.ResourceBundle;

public abstract class Bundle {
	
	public ResourceBundle RB;
	public String LANGUAGE;
	
	public String Forward;
	public String Backward;
	public String Left;
	public String Right;
	public String SetHeading;
	public String SetTowards;
	public String SetPosition;
	public String PenDown;
	public String PenUp;
	public String ShowTurtle;
	public String HideTurtle;
	public String Home;
	public String ClearScreen;
	
	public String XCoordinate;
	public String YCoordinate;
	public String Heading;
	public String IsPenDown;
	public String IsShowing;
	
	public String Sum;
	public String Difference;
	public String Product;
	public String Quotient;
	public String Remainder;
	public String Minus;
	public String Random;
	public String Sine;
	public String Cosine;
	public String Tangent;
	public String ArcTangent;
	public String NaturalLog;
	public String Power;
	public String Pi;
	
	public String LessThan;
	public String GreaterThan;
	public String Equal;
	public String NotEqual;
	public String And;
	public String Or;
	public String Not;
	
	public String MakeVariable;
	public String Repeat;
	public String DoTimes;
	public String For;
	public String If;
	public String IfElse;
	public String MakeUserInstruction;
	
	public String SetBackground;
	public String SetPenColor;
	public String SetPenSize;
	public String SetShape;
	public String SetPalette;
	public String GetPenColor;
	public String GetShape;
	public String Stamp;
	public String ClearStamps;
	
	public String ID;
	public String Turtles;
	public String Tell;
	public String Ask;
	public String AskWith;
	
	public Bundle(String theLanguage){
		LANGUAGE = theLanguage;
		bundleChooser();
		bundleDecoder();
	}
	
	public abstract void bundleChooser();

	public void bundleDecoder(){
		
		Forward = RB.getString("Forward");
		Backward = RB.getString("Backward");
		Left = RB.getString("Left");
		Right = RB.getString("Right");
		SetHeading = RB.getString("SetHeading");
		SetTowards = RB.getString("SetTowards");
		SetPosition = RB.getString("SetPosition");
		PenDown = RB.getString("PenDown");
		PenUp = RB.getString("PenUp");
		ShowTurtle = RB.getString("ShowTurtle");
		HideTurtle = RB.getString("HideTurtle");
		Home = RB.getString("Home");
		ClearScreen = RB.getString("ClearScreen");
		
		XCoordinate = RB.getString("XCoordinate");
		YCoordinate = RB.getString("YCoordinate");
		Heading = RB.getString("Heading");
		IsPenDown = RB.getString("IsPenDown");
		IsShowing = RB.getString("IsShowing");
		
		Sum = RB.getString("Sum");
		Difference = RB.getString("Difference");
		Product = RB.getString("Product");
		Quotient = RB.getString("Quotient");
		Remainder = RB.getString("Remainder");
		Minus = RB.getString("Minus");
		Random = RB.getString("Random");
		Sine = RB.getString("Sine");
		Cosine = RB.getString("Cosine");
		Tangent = RB.getString("Tangent");
		ArcTangent = RB.getString("ArcTangent");
		NaturalLog = RB.getString("NaturalLog");
		Power = RB.getString("Power");
		Pi = RB.getString("Pi");
		
		LessThan = RB.getString("LessThan");
		GreaterThan = RB.getString("GreaterThan");
		Equal = RB.getString("Equal");
		NotEqual = RB.getString("NotEqual");
		And = RB.getString("And");
		Or = RB.getString("Or");
		Not = RB.getString("Not");
		
		MakeVariable = RB.getString("MakeVariable");
		Repeat = RB.getString("Repeat");
		DoTimes = RB.getString("DoTimes");
		For = RB.getString("For");
		If = RB.getString("If");
		IfElse = RB.getString("IfElse");
		MakeUserInstruction = RB.getString("MakeUserInstruction");
		
		SetBackground = RB.getString("SetBackground");
		SetPenColor = RB.getString("SetPenColor");
		SetPenSize = RB.getString("SetPenSize");
		SetShape = RB.getString("SetShape");
		SetPalette = RB.getString("SetPalette");
		GetPenColor = RB.getString("GetPenColor");
		GetShape = RB.getString("GetShape");
		Stamp = RB.getString("Stamp");
		ClearStamps = RB.getString("ClearStamps");
		
		ID = RB.getString("ID");
		Turtles = RB.getString("Turtles");
		Tell = RB.getString("Tell");
		Ask = RB.getString("Ask");
		AskWith = RB.getString("AskWith");
	}
	
}
