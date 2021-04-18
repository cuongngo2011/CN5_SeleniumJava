package element.common.imp;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import common.Constants;
import element.base.imp.Editable;
import element.common.ICheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckBox extends Editable implements ICheckBox {

    public CheckBox(By locator) {
        super(locator);
    }

    public CheckBox(String locator) {
        super(locator);
    }

    public CheckBox(String locator, Object... value) {
        super(locator, value);
    }

    @Override
    public void check() {
        if (!isChecked()) {
            click();
        }
    }

    @Override
    public void uncheck() {
        if (isChecked()) {
            click();
        }
    }

    @Override
    public boolean isChecked() {
        return isSelected();
    }

    @Override
    public void set(boolean value) {
        if (value) {
            check();
        } else {
            uncheck();
        }
    }

    @Override
    public void setAll(boolean value) {
        List<WebElement> elements = getElements();
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if ((!element.isSelected() && value) || (element.isSelected() && !value)) {
                element.click();
            }
        }
    }

    @Override
    public void waitForCheckBoxIsChecked() {
        List<WebElement> elements = getElements();
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            WebDriverWait wait = new WebDriverWait(getDriver(), Constants.WAIT_TIME.SHORT);
            wait.until(ExpectedConditions.elementToBeSelected(element));
        }
    }
}
