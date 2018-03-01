package resources.languages;

import java.util.ResourceBundle;

public class EnglishBundle extends Bundle{
	
	public EnglishBundle(String theLang){
		super(theLang);
	}

	@Override
	public void bundleChooser() {
		RB = ResourceBundle.getBundle("English");
	}
	
}
