package element.common.imp;

import element.base.imp.Clickable;
import element.common.IDatePicker;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DatePicker extends Clickable implements IDatePicker {
    public DatePicker(By byLocator) {
        super(byLocator);

    }

    public DatePicker(String locator, Object... args) {
        super(locator, args);
    }

    public DatePicker(String locator) {
        super(locator);
    }

    public LocalDate getCurrentPeriod(){
        String[] currentPeriod = getElement().getAttribute("value").split("/");
        return LocalDate.of(
                Integer.parseInt(currentPeriod[2]),
                Month.of(Integer.parseInt(currentPeriod[1])),
                1);
    }

    public void chooseMonth(int year, int month, Button leftArrow, Button rightArrow) {
        LocalDate currentPeriod = getCurrentPeriod();
        long monthsAway = ChronoUnit.MONTHS.between(currentPeriod, LocalDate.of(year,Month.of(month), 1));

        Button arrow = monthsAway < 0 ? leftArrow : rightArrow;

        for(int i = 0; i < Math.abs(monthsAway); i++){
            arrow.click();
        }
    }

    public void chooseDay(By dayLocator) {
        getDriver().findElement(dayLocator).click();
    }

    public void openDatePicker(){
        getElement().click();
    }
}
