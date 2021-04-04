package element.common.imp;

import element.base.imp.Clickable;
import element.common.ILabel;
import org.openqa.selenium.By;

public class Label extends Clickable implements ILabel {

	public Label(By locator) {
		super(locator);
	}

	public Label(String locator) {
		super(locator);
	}

	public Label(String locator, Object... value) {
		super(locator, value);
	}

}
