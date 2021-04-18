package test.railway.page;

import element.common.imp.Button;
import element.common.imp.Label;
import element.common.imp.TextBox;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterPage extends GeneralPage {

    //Elements
    private Label createAccuntLabel = new Label("//h1[contains(text(),'Create account')]");
    private TextBox txtEmail = new TextBox("id=email");
    private TextBox txtPassword = new TextBox("id=password");
    private TextBox txtConfirmPassword = new TextBox("id=confirmPassword");
    private TextBox txtPID = new TextBox("id=pid");
    private Button btnRegister = new Button("//form[@id='RegisterForm']/");
    private Label registerMsg = new Label("//div[@id='content']/p");
    private Label lblRegisterErrorMsg = new Label("//div[@id='content']/p[@class='message error']");
    private Label lblPasswordErrorMsg = new Label("//label[@for='password' and @class='validation-error']");
    private Label lblPidErrorMsg = new Label("//label[@for='pid' and @class='validation-error']");



    //Methods
    public boolean isCreateAcountLabelDisplayed() {
        createAccuntLabel.waitForDisplay();
        return createAccuntLabel.isDisplayed();
    }

    public void register(String email, String password,
                         String confirmPassword, String pid) {
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(confirmPassword);
        fillPID(pid);
        clickBtnRegister();
    }

    public void fillEmail(String email) {
        txtEmail.waitForDisplay();
        txtEmail.enter(email);
    }

    public void fillPassword(String password) {
        txtPassword.waitForDisplay();
        txtPassword.enter(password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        txtConfirmPassword.waitForDisplay();
        txtConfirmPassword.enter(confirmPassword);
    }

    public void fillPID(String pid) {
        txtPID.waitForDisplay();
        txtPID.enter();
    }

    public void clickBtnRegister() {
        btnRegister.waitForDisplay();
        btnRegister.scrollToView();
        btnRegister.click();
    }


    public String getRegisterMsg() {
        registerMsg.waitForDisplay();
        return registerMsg.getText();
    }

    public String getRegisterErrorMsg() {
        lblRegisterErrorMsg.waitForDisplay();
        return lblRegisterErrorMsg.getText();
    }

    public String getLablePasswordErrorMsg() {
        lblPasswordErrorMsg.waitForDisplay();
        return lblPasswordErrorMsg.getText();
    }

    public String getLablePIDErrorMsg() {
        lblPidErrorMsg.waitForDisplay();
        return lblPidErrorMsg.getText();
    }

    public String randomEmail() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
        String emailRandom = "test" + formatter.format(date) + "@gmail.com";
        return emailRandom;
    }
}
