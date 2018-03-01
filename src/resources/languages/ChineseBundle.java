package resources.languages;

import java.util.ResourceBundle;

public class ChineseBundle extends Bundle{
	
	public ChineseBundle(String theLang){
		super(theLang);
	}

	@Override
	public void bundleChooser() {
		RB = ResourceBundle.getBundle("resources/languages/Chinese");
	}
	
}
