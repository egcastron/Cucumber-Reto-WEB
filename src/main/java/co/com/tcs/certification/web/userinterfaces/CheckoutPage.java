package co.com.tcs.certification.web.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    public static final Target INPUT_PHONE = Target.the("input phone").located(By.xpath("//input[@id='address_mobilePhone']"));
    public static final Target INPUT_ID = Target.the("input id").located(By.xpath("//input[@id='address_nationalRegistrationNumber']"));
    public static final Target INPUT_ADDRESS = Target.the("input address").located(By.xpath("//input[@id='address_line1']"));
    public static final Target INPUT_NEIGHBHD = Target.the("input neighborhood").located(By.xpath("//input[@id='address_neighborhood']"));
    public static final Target SLC_REGION = Target.the("select region").located(By.xpath("//select[@id='address_region']"));
    public static final Target SLC_MUNICIP = Target.the("select municipaly").located(By.xpath("//select[@id='address_municipality']"));
    public static final Target BTN_SAVE = Target.the("boton save").located(By.xpath("//button[contains(text(), 'Guardar direcci')]"));

}
