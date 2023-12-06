import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccountsOverview extends BasePage {

private By AccountsOverview = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");

private By MensajeAccountsOverview = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");
    public AccountsOverview(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

      public void clickAccountsOverview() throws InterruptedException {
         click(AccountsOverview);
      }

      public String obtenerMensajeAccountsOverview() throws InterruptedException {
         return this.getText(MensajeAccountsOverview);
      }
}
