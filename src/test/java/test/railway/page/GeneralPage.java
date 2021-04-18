package test.railway.page;

import element.common.imp.Label;
import element.common.imp.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //dynamic Control
    private Link tabMenu = new Link("//div[@id='menu']//a[.='%s']");

    //Elements
    private Link tabLogin = new Link("xpath=//div[@id='menu']//a[.='Login']");

    private Link tabRegister = new Link("xpath=//div[@id='menu']//a[.='Register']");

    private Link tabLogout = new Link("xpath=//div[@id='menu']//a[.='Log out']");

    private Link tabBookTicket = new Link("xpath=//div[@id='menu']//a[.='Book ticket']");

    private Label lblWelcomeMessage = new Label("xpath=//div[@class='account']/strong");

    private Link tabContact = new Link("xpath=//div[@id='menu']//a[.='Contact']");

    private Link tabMyTicket = new Link("xpath=//div[@id='menu']//li[.='My ticket']");

    private Link tabChangePassword = new Link("xpath=//div[@id='menu']//li[.='Change password']");

    private Link tabTicketPrice = new Link("xpath=//div[@id='menu']//li[.='Ticket price']");


    //Methods
    public String getWelcomeMsg() {
        lblWelcomeMessage.waitForDisplay();
        return lblWelcomeMessage.getText();
    }

    public void goToContactPage() { ;
        tabContact.waitForDisplay();
        tabContact.click();
    }

    public void goToLoginPage() {
        tabLogin.waitForDisplay();
        tabLogin.click();
    }

    public void logout() {
        tabLogout.click();
    }

    public void goToRegisterPage() {
        tabRegister.waitForDisplay();
        tabRegister.click();
    }

    public void goToBookTicketPage() {
        tabBookTicket.waitForDisplay();
        tabBookTicket.click();
    }

    public void goToTicketPricePage() {
        tabTicketPrice.waitForDisplay();
        tabTicketPrice.click();
    }

    public void goToMyTicketPage() {
        tabMyTicket.waitForDisplay();
        tabMyTicket.click();
    }

    public void goToChangePasswordPage() {
        tabChangePassword.waitForDisplay();
        tabChangePassword.click();
    }

    public boolean isTabMenuSelected(String menu) {
        tabMenu.setDynamicValue(menu);
        tabMenu.waitForDisplay();
        return tabMenu.getAttribute("class").equals("selected");
    }
}
