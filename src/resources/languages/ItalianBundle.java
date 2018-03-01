package resources.languages;

import java.util.ResourceBundle;

public class ItalianBundle extends Bundle{
	
	public ItalianBundle(String theLang){
		super(theLang);
	}

	@Override
	public void bundleChooser() {
		RB = ResourceBundle.getBundle("Italian");
	}
	
}
