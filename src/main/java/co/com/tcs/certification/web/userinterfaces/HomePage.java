package co.com.tcs.certification.web.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target LEFT_MENU = Target.the("left menu").located(By.id("open-left-menu"));
    public static final Target CELULARES_MENU = Target.the("celulares menu").located(By.xpath("(//a[@class='nav-link'])[2]"));
    public static final Target BELLEZA_MENU = Target.the("belleza menu").located(By.xpath("(//a[@class='nav-link'])[12]"));
    public static final Target MODA_MENU = Target.the("moda menu").located(By.xpath("(//a[@class='nav-link'])[9]"));
    public static final Target CART = Target.the("cart").located(By.id("cart-counter"));


}
