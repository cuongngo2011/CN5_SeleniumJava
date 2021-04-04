package element.common;

import element.base.IClickable;

import java.util.List;

public interface IComboBox extends IClickable {
	void select(String text);

	void select(int index);

	String getSelected();

	List<String> getOptions();
	
	void waitForSelectedOptionToBePresent(String option, int timeOutInSecond); 

}
