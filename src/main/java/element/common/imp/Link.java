package element.common.imp;

import element.base.imp.Editable;
import element.common.ILink;
import org.openqa.selenium.By;

public class Link extends Editable implements ILink {

	public Link(String locator) {
		super(locator);
	}

	public Link(By locator) {
		super(locator);
	}

	public Link(String locator, Object... value) {
		super(locator, value);
	}

	public String getReference() {
		return getAttribute("href");
	}

}
