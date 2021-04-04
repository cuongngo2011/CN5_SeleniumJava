package element.common;

import element.base.IEditable;

public interface ICheckBox extends IEditable {

	void check();

	void uncheck();

	void set(boolean value);

	void setAll(boolean value);

	boolean isChecked();

	void waitForCheckBoxIsChecked();
}
