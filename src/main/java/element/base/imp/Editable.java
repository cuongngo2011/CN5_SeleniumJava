package element.base.imp;

import driver.DriverUtils;
import element.base.IEditable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class Editable extends Clickable implements IEditable {

	private static Logger logger = LogManager.getLogger(Editable.class);

	public Editable(String locator) {
		super(locator);
	}

	public Editable(By locator) {
		super(locator);
	}

	public Editable(String locator, Object... value) {
		super(locator, value);
	}

	@Override
	public void setText(String value) {
		
	}

	@Override
	public void enter(CharSequence... value) {
		try {
			logger.debug(String.format("Enter '%s' for %s", value, getLocator()
					.toString()));
			getElement().clear();
			getElement().sendKeys(value);
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
			throw e;
		}

	}

    public void enterEachCharacter(String string) {
        String[] parts = string.split("(?!^)");
        for (int i = 0; i < parts.length; i++) {
            getElement().sendKeys(parts[i]);
            DriverUtils.delay(0.1);
        }
    }
	
	public void sendKeyboard(CharSequence... value){
		try {
			logger.debug(String.format("Enter '%s' for %s", value, getLocator()
					.toString()));
			getElement().sendKeys(value);
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
			throw e;
		}
	}

	@Override
	public void setValue(String value) {
		try {
			String js = String.format("arguments[0].value='%s';", value);
			logger.debug(String.format("Set value '%s' for %s", value,
					getLocator().toString()));
			jsExecutor().executeScript(js, getElement());
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
			throw e;
		}

	}

	@Override
	public void clear() {
		try {
			logger.debug(String.format("Clean text for %s", getLocator()
					.toString()));
			getElement().clear();
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
			throw e;
		}

	}
}
