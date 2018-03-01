package resources.languages;

import java.util.ResourceBundle;

public class RussianBundle extends Bundle{
	
	public RussianBundle(String theLang){
		super(theLang);
	}

	@Override
	public void bundleChooser() {
		RB = ResourceBundle.getBundle("Russian");
	}
	
}
