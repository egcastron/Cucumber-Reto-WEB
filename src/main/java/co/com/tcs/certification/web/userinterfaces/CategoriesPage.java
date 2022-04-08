package co.com.tcs.certification.web.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CategoriesPage {

    public static final Target LBL_CATEGORIES = Target.the("laber categories").locatedBy("//h1[contains(text(), '{0}')]");
    public static final Target SPAN_PRODUCTS = Target.the("span productos").locatedBy("//span[contains(text(), '{0}')]");

}
