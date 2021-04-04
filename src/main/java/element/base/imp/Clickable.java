package element.base.imp;

import element.base.IClickable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Clickable extends Element implements IClickable {

	private static Logger logger = LogManager.getLogger(Clickable.class);

	public Clickable(String locator) {
		super(locator);
	}

	public Clickable(By locator) {
		super(locator);
	}

	public Clickable(String locator, Object... value) {
		super(locator, value);
	}

	@Override
	public void click() {
		try {
			logger.debug(String.format("Click on %s", getLocator().toString()));
			getElement().click();
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
			throw e;
		}
	}

	@Override
	public void click(int x, int y) {
		try {
			logger.debug(String.format("Click on %s", getLocator().toString()));
			new Actions(getDriver()).moveToElement(getElement(), x, y).click()
					.build().perform();
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
			throw e;
		}
	}

	@Override
	public void clickByJs() {
		try {
			logger.debug(String.format("Click by js on %s", getLocator()
					.toString()));
			jsExecutor().executeScript("arguments[0].click();", getElement());
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
			throw e;
		}
	}

	@Override
	public void doubleClick() {
		try {
			logger.debug(String.format("Double click on %s", getLocator()
					.toString()));
			new Actions(getDriver()).doubleClick(getElement()).build()
					.perform();
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
			throw e;
		}

	}

}
