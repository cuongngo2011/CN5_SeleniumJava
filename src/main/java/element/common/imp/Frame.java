package element.common.imp;

import element.base.imp.Element;
import element.common.IFrame;
import org.openqa.selenium.By;

public class Frame extends Element implements IFrame {

	public Frame(By locator) {
		super(locator);
	}

	public Frame(String locator) {
		super(locator);
	}

	public Frame(String locator, Object... value) {
		super(locator, value);
	}

	@Override
	public void switchTo() {
		getDriver().switchTo().frame(getElement());
	}

	@Override
	public void switchToMainDocument() {
		getDriver().switchTo().defaultContent();
	}

}
