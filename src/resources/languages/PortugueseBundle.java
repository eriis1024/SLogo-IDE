package resources.languages;

import java.util.ResourceBundle;

public class PortugueseBundle extends Bundle{
	
	public PortugueseBundle(String theLang){
		super(theLang);
	}

	@Override
	public void bundleChooser() {
		RB = ResourceBundle.getBundle("Portuguese");
	}
	
}
