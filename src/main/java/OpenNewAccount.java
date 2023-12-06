import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccount extends BasePage {


    private By newAccount = By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a");
    private By accountType = By.xpath("//*[@id=\"type\"]");

    private By openNewAccount = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    private By MensajeNewAccount = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");

    public OpenNewAccount(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

      public void clickOpenNewAccount() throws InterruptedException {
         click(newAccount);
      }
      public void clickOpenNewAccountButton() throws InterruptedException {
         click(openNewAccount);
      }
    public void selectAccountType(String option) {
        Select select = new Select(driver.findElement(accountType));
        select.selectByVisibleText(option);
    }

      public String obtenerMensajeNewAccount() throws InterruptedException {
         return this.getText(MensajeNewAccount);
      }

}
