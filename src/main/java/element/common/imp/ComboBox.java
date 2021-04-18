package element.common.imp;

import element.base.imp.Clickable;
import element.base.imp.Element;
import element.common.IComboBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ComboBox extends Clickable implements IComboBox {

	private static Logger logger = LogManager.getLogger(Element.class);

	public ComboBox(By locator) {
		super(locator);
	}

	public ComboBox(String locator) {
		super(locator);
	}

	public ComboBox(String locator, Object... value) {
		super(locator, value);
	}

	@Override
	public void select(String text) {
		Select select = new Select(getElement());
		select.selectByVisibleText(text);

	}

	public void selectByValue(String value){
		Select select = new Select(getElement());
		select.selectByValue(value);
	}

	public void selectActionDropdown(String option) {
		WebElement dropdown = getElement();
		dropdown.click();
		List<WebElement> itemList = dropdown.findElements(By.tagName("li"));
		for (WebElement li : itemList) {
			if (li.getText().contains(option)) {
				li.click();
				break;
			}
		}
	}

	public void selectMultiOptionDropdown(String... options) {
		WebElement dropdown = getElement();
		dropdown.click();
		List<WebElement> itemList = dropdown.findElements(By.xpath("ul/li/a/span"));
		List<WebElement> itemList2 = dropdown.findElements(By.xpath("ul/li/a"));

		for (int i = 0; i < itemList.size(); i++) {
			if (!itemList.get(i).getAttribute("class").contains("glyphicon-hide")) {
				itemList2.get(i).click();
			}
		}
		for (WebElement li : itemList2) {
			for (int i = 0; i < options.length; i++) {
				if (li.getText().trim().replace("&nbsp;", "").equals(options[i])) {
					li.click();
				}
			}
		}
		dropdown.click();
	}

	@Override
	public void select(int index) {
		Select select = new Select(getElement());
		select.selectByIndex(index);
	}

	@Override
	public String getSelected() {
		Select select = new Select(getElement());
		return select.getFirstSelectedOption().getText();
	}

	@Override
	public List<String> getOptions() {
		List<String> ops = new ArrayList<String>();
		Select select = new Select(getElement());
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			ops.add(option.getText());
		}
		return ops;
	}

	@Override
	public void waitForSelectedOptionToBePresent(String option, int timeOutInSecond) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSecond);
			wait.until(new Function<WebDriver, Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					Boolean isSelected = (Boolean) jsExecutor().executeScript(String
							.format("var ele = arguments[0];return ele.options[ele.selectedIndex].text=='%s';", option),
							getElement());
					return isSelected;
				}
			});
		} catch (Exception e) {
			logger.error(String.format("waitForSelectedOptionToBePresent: Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
		}
	}
}
