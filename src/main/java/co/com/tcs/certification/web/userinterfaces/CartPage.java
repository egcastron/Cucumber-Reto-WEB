package co.com.tcs.certification.web.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target LBL_CART_PROD = Target.the("label prod 1").locatedBy("//a[contains(text(), '{0}')]");
    public static final Target BTN_DELETE = Target.the("boton delete").located(By.xpath("(//a[@ng-clicl='cart.removeItem(item.sku)'])[1]"));
    public static final Target A_INICIO = Target.the("a inicio").located(By.xpath("(//a[@ng-clicl='cart.removeItem(item.sku)'])[1]"));
    public static final Target H2_MSG_EMPTY = Target.the("h2 msg empty").located(By.xpath("//h2[@class='highlight col-md-6 col-md-offset-3 offset-md-3']"));
    public static final Target BTN_PROCESS = Target.the("button process").located(By.xpath("//a[@class='btn btn-lg btn-primary summary-btn-process-pay col-md-12']"));



}
