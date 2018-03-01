package resources.languages;

import java.util.ResourceBundle;

public class FrenchBundle extends Bundle{
	
	public FrenchBundle(String theLang){
		super(theLang);
	}

	@Override
	public void bundleChooser() {
		RB = ResourceBundle.getBundle("French");
	}
	
}
