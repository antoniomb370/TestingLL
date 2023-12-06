import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By usermane = By.xpath("//input[@name='username']");
    private By contrasena = By.xpath("//input[@name='password']");
    private By sumitButtom = By.xpath("//input[@value='Log In']");
    private By MensajeAccounts = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");
    private By mensajeResumenCuenta = By.xpath("//table[@id='accountTable']//tfoot//tr");
    private By mensajeError = By.xpath("//*[@id=\"rightPanel\"]/p");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void fillLoginForm(String mail, String clave) throws InterruptedException {
        sendText(mail, usermane);
        sendText(clave, contrasena);
    }

    public void clickLogin() throws InterruptedException {
        click(sumitButtom);
    }

    public void login(String email, String pass) throws InterruptedException {
        fillLoginForm(email, pass);
        clickLogin();
    }

    public String obtenerMensajeVienvenida() throws InterruptedException {
        return this.getText(MensajeAccounts);
    }

    public String obtenerMensajeAccounts() throws InterruptedException {
        return this.getText(mensajeResumenCuenta);
    }

      public String obtenerMensajeError() throws InterruptedException {
         System.out.println("MENSAJE DE ERROR: " + getText(mensajeError));
         return this.getText(mensajeError);
      }

//
}
