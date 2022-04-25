package co.com.tcs.certification.web.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountPage {
    public static final Target INPUT_EMAIL = Target.the("input email").located(By.id("login_form_email"));
    public static final Target INPUT_PASSWORD = Target.the("input password").located(By.id("login_form_password"));
    public static final Target BTN_LOGIN = Target.the("btn login").located(By.xpath("//button[@class='btn btn-security col-12']"));
}
