package element.common.imp;

import element.base.imp.Editable;
import element.common.ITextBox;
import org.openqa.selenium.By;

public class TextBox extends Editable implements ITextBox {

	public TextBox(String locator) {
		super(locator);
	}

	public TextBox(By locator) {
		super(locator);
	}

	public TextBox(String locator, Object... value) {
		super(locator, value);
	}
}
