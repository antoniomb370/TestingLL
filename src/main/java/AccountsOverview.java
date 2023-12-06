import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccountsOverview extends BasePage {

    private By AccountsOverview = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");
    private By clickingAccountsDetails = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    private By MensajeAccountsOverview = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");
    private By MensajeAccountsDetails = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");

    private By ActivityPeriod = By.xpath("//*[@id=\"month\"]");
    private By TypeAccount = By.id("transactionType");
    private By clickingGo = By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");



    public AccountsOverview(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAccountsOverview() throws InterruptedException {
        click(AccountsOverview);
    }

    public void clickAccountsDetails() throws InterruptedException {
        click(clickingAccountsDetails);
    }

    public String obtenerMensajeAccountsOverview() throws InterruptedException {
        return this.getText(MensajeAccountsOverview);
    }

    public String obtenerMensajeAccountsDetails() throws InterruptedException {
        return this.getText(MensajeAccountsDetails);
    }

     public void selectActivityPeriod(String option) {
         Select select = new Select(driver.findElement(ActivityPeriod));
         select.selectByValue(option);
      }

      public void selectTypeAccount(String option) {
         Select select = new Select(driver.findElement(TypeAccount));
         select.selectByValue(option);
      }

      public void clickGo() throws InterruptedException {
         click(clickingGo);
      }

}
