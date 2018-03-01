package resources.languages;

import java.util.ResourceBundle;

public class SpanishBundle extends Bundle{
	
	public SpanishBundle(String theLang){
		super(theLang);
	}

	@Override
	public void bundleChooser() {
		RB = ResourceBundle.getBundle("resources/languages/Spanish");
	}
	
}
