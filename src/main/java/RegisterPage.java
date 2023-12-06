import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegisterPage extends BasePage {


    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phoneNumber = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By repeatedPassword = By.id("repeatedPassword");
    private By registerButton = By.xpath("//input[@value='Register']");
    private By registrarseBtn = By.xpath("//a[normalize-space()='Register']");

    private By successMessage = By.xpath("//*[@id=\"rightPanel\"]/p");
    private By welcomeMessage = By.xpath("//*[@id=\"rightPanel\"]/h1");

    private By mensajeUsuarioExistente = By.id("customer.username.errors");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void fillRegistrationForm(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String ssn, String username, String password, String repeatedPassword) throws InterruptedException {
        sendText(firstName, this.firstName);
        sendText(lastName, this.lastName);
        sendText(address, this.address);
        sendText(city, this.city);
        sendText(state, this.state);
        sendText(zipCode, this.zipCode);
        sendText(phoneNumber, this.phoneNumber);
        sendText(ssn, this.ssn);
        sendText(username, this.username);
        sendText(password, this.password);
        sendText(repeatedPassword, this.repeatedPassword);
    }

    public RegisterPage(WebDriver driver, WebDriverWait wait, By username) {
        super(driver, wait);
        this.username = username;
    }

    public void clickRegistrarse() throws InterruptedException {
        click(registrarseBtn);
    }

    public void clickRegister() throws InterruptedException {
        click(registerButton);
    }

    public String getSuccessMessage() throws InterruptedException {
        return this.getText(successMessage);
    }

    public String getWelcomeMessage() throws InterruptedException {
        return this.getText(welcomeMessage);
    }

    public String getErrorMessage() throws InterruptedException {
        return this.getText(mensajeUsuarioExistente);
    }

}
