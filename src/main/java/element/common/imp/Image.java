package element.common.imp;

import element.base.imp.Clickable;
import element.common.IImage;
import org.openqa.selenium.By;

public class Image extends Clickable implements IImage {

	public Image(By locator) {
		super(locator);
	}

	public Image(String locator) {
		super(locator);
	}

	public Image(String locator, Object... value) {
		super(locator, value);
	}

	@Override
	public String getSource() {
		return getElement().getAttribute("src");
	}

	@Override
	public String getAlt() {
		return getElement().getAttribute("alt");
	}

}
