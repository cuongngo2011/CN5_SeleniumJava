package element.common.imp;

import element.base.imp.Clickable;
import element.common.IButton;
import org.openqa.selenium.By;

public class Button extends Clickable implements IButton {

    public Button(String locator) {
        super(locator);
    }

    public Button(By locator) {
        super(locator);
    }

    public Button(String locator, Object... value) {
        super(locator, value);
    }

    private Button loginButton = new Button("//xpth");
}
