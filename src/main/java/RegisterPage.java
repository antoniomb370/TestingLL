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


    //mensaje de registro exitoso Your account was created successfully. You are now logged in.
    //mensjae con el nombre del usuario Welcome test2

    // <div id="rightPanel">
    //
    //
    //
    //<h1 class="title">Welcome test2</h1>
    //
    //<p>Your account was created successfully. You are now logged in.</p>
    //				</div>

    // selector //*[@id="rightPanel"]/h1 mensaje con el nombre del usuario

    // //*[@id="rightPanel"]/p mensaje de registro exitoso

    // SELECTOR MENSAJE NUEVA CUENTA  //*[@id="rightPanel"]/div/div/h1  MENSAJE NUEVA CUENTA <h1 class="title">Account Opened!</h1>
    // <p>Congratulations, your account is now open.</p>  SELECTOR //*[@id="rightPanel"]/div/div/p[1]


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

    public By getFirstName() {
        return firstName;
    }

    public void setFirstName(By firstName) {
        this.firstName = firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public void setLastName(By lastName) {
        this.lastName = lastName;
    }

    public By getAddress() {
        return address;
    }

    public void setAddress(By address) {
        this.address = address;
    }

    public By getCity() {
        return city;
    }

    public void setCity(By city) {
        this.city = city;
    }

    public By getState() {
        return state;
    }

    public void setState(By state) {
        this.state = state;
    }

    public By getZipCode() {
        return zipCode;
    }

    public void setZipCode(By zipCode) {
        this.zipCode = zipCode;
    }

    public By getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(By phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public By getSsn() {
        return ssn;
    }

    public void setSsn(By ssn) {
        this.ssn = ssn;
    }

    public By getUsername() {
        return username;
    }

    public void setUsername(By username) {
        this.username = username;
    }

    public By getPassword() {
        return password;
    }

    public void setPassword(By password) {
        this.password = password;
    }

    public By getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(By repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
