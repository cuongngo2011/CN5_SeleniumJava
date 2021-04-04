package element.base;

public interface IClickable extends IElement {

	void click();

	void click(int x, int y);

	void clickByJs();

	void doubleClick();
}
