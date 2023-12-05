import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataValidator extends BasePage {


    private By firstNameError = By.id("customer.firstName.errors");
    private By lastNameError = By.id("customer.lastName.errors");
    private By addressError = By.id("customer.address.street.errors");
    private By cityError = By.id("customer.address.city.errors");
    private By stateError = By.id("customer.address.state.errors");
    private By zipCodeError = By.id("customer.address.zipCode.errors");
    private By ssnError = By.id("customer.ssn.errors");
    private By usernameError = By.id("customer.username.errors");
    private By passwordError = By.id("customer.password.errors");
    private By confirmPasswordError = By.id("repeatedPassword.errors");

    private By mensajePasswordNotMatch = By.id("repeatedPassword.errors");



    public DataValidator(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

      public String getFirstNameError() throws InterruptedException {
         return this.getText(firstNameError);
      }

      public String getLastNameError() throws InterruptedException {
         return this.getText(lastNameError);
      }

      public String getAddressError() throws InterruptedException {
         return this.getText(addressError);
      }

      public String getCityError() throws InterruptedException {
         return this.getText(cityError);
      }

      public String getStateError() throws InterruptedException {
         return this.getText(stateError);
      }

      public String getZipCodeError() throws InterruptedException {
         return this.getText(zipCodeError);
      }

      public String getSsnError() throws InterruptedException {
         return this.getText(ssnError);
      }

      public String getUsernameError() throws InterruptedException {
         return this.getText(usernameError);
      }

      public String getPasswordError() throws InterruptedException {
         return this.getText(passwordError);
      }

      public String getConfirmPasswordError() throws InterruptedException {
         return this.getText(confirmPasswordError);
      }

      public String getMensajePasswordNotMatch() throws InterruptedException {
         return this.getText(mensajePasswordNotMatch);
      }

}
