package co.com.tcs.certification.web.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {

    public static final Target BTN_ANADIR = Target.the("boton añadir").located(By.id("buy-now"));
    public static final Target BTN_CONTINUE = Target.the("boton continue").located(By.xpath("//a[@class='btn btn-sm btn-go-to-cart added-product']"));

}
