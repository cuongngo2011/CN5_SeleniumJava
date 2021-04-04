package element.common.imp;

import element.base.imp.Clickable;
import element.common.IRadioButton;
import org.openqa.selenium.By;

public class RadioButton extends Clickable implements IRadioButton {

    public RadioButton(String locator) {
        super(locator);
    }

    public RadioButton(By locator) {
        super(locator);
    }

    public RadioButton(String locator, Object... value) {
        super(locator, value);
    }
}
