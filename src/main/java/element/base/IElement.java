package element.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IElement {

	WebElement getElement();

	List<WebElement> getElements();

	void setAttributeJS(String attributeName, String value);

	String getText();

	String getValue();
	
	String getLocatorAsString();
	
	By getLocator();

	void setDynamicValue(Object... args);

	String getAttribute(String attributeName);

	boolean isDisplayed();

	boolean isEnabled();

	boolean isSelected();

	void waitForDisplay();

	void waitForDisplay(int timeOutInSeconds);

	void submit();

	void waitForTextToBePresent(String text, int timeOutInSecond);

	void waitForTextToBeNotPresent(String text, int timeOutInSecond);

	void waitForElementNotPresent(int timeOutInSecond);

	void waitForValueNotPresentInAttribute(String attribute, String value,
                                           int timeOutInSecond);

	void waitForValuePresentInAttribute(String attribute, String value,
                                        int timeOutInSecond);

	void waitForElementEnabled(int timeOutInSecond);

	void waitForElementEnabled();

	void waitForElementDisabled(int timeOutInSecond);

	void waitForElementDisabled();

	boolean isDisplayed(int timeOutInSeconds);

	void scrollToView();

	void waitForPresent();

	void waitForPresent(int timeOutInSecond);
	
	void waitForAngularLoad(int timeOutInSecond);

	void moveTo();

	String getClassName();

	void mouseHoverJScript();
	
	String getTagName();

	int countElement();

}
