import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
        private By email = By.id("email");
        private By contrasena = By.id("password");
        private By sumitButtom = By
                .xpath("//button[@class='btn btn-primario btn-sm' and @type='submit' and text()='Ingresar']");
        private By mensajeError = By.className("form-feedback");

        public LoginPage(WebDriver driver, WebDriverWait wait) {
            super(driver, wait);
        }

//        public void escribirMail(String mail) throws InterruptedException {
//            sendText(mail, email);
//        }
//
//        public void escribirContrasena(String clave) throws InterruptedException {
//            sendText(clave, contrasena);
//        }
//
//        public void clickIngresar() throws InterruptedException {
//            click(sumitButtom);
//        }
//
//        public String obtenerMensajeError() throws InterruptedException {
//            System.out.println("MENSAJE DE ERROR: " + getText(mensajeError));
//            return this.getText(mensajeError);
//        }
}
