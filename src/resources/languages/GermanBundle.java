package resources.languages;

import java.util.ResourceBundle;

public class GermanBundle extends Bundle{
	
	public GermanBundle(String theLang){
		super(theLang);
	}

	@Override
	public void bundleChooser() {
		RB = ResourceBundle.getBundle("resources/languages/German");
	}
	
}
