import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundTransfer extends BasePage {

    private By FundTransfer = By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a");
    private By MensajeFundTransfer = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");
    private By Amount = By.xpath("//*[@id=\"amount\"]");

    private By FromAccount = By.xpath("//*[@id=\"fromAccountId\"]");

    private By ToAccount = By.xpath("//*[@id=\"toAccountId\"]");

    private By Transfer = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input");

    private By MensajeTransfer = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");

    public FundTransfer(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void clickFundTransfer() throws InterruptedException {
        click(FundTransfer);
    }

    public String obtenerMensajeFundTransfer() throws InterruptedException {
        return this.getText(MensajeFundTransfer);
    }

    public void enterAmount(String amount) throws InterruptedException {
        sendText(amount, Amount);
    }

    public void selectFromAccount(String option) {
        Select select = new Select(driver.findElement(FromAccount));
        select.selectByValue(option);
    }

    public void selectToAccount(String option) {
        Select select = new Select(driver.findElement(ToAccount));
        select.selectByValue(option);
    }
    public void clickTransfer() throws InterruptedException {
        click(Transfer);
    }
    public String obtenerMensajeTransfer() throws InterruptedException {
        return this.getText(MensajeTransfer);
    }

 }
