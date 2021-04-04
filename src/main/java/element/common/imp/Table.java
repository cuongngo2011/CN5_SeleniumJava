package element.common.imp;

import element.base.imp.Clickable;
import element.common.ITable;
import org.openqa.selenium.By;

public class Table extends Clickable implements ITable {

	public Table(String locator) {
		super(locator);
	}

	public Table(By locator) {
		super(locator);
	}

	public Table(String locator, Object... value) {
		super(locator, value);
	}
}
