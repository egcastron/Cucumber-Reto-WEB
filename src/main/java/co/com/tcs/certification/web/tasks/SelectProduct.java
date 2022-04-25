package co.com.tcs.certification.web.tasks;

import co.com.tcs.certification.web.models.ProductAndLogin;
import co.com.tcs.certification.web.models.Products;
import co.com.tcs.certification.web.userinterfaces.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

public class SelectProduct implements Task {

    private String category;
    private String product;
    private String email;
    private String password;

    public SelectProduct(List<ProductAndLogin> prodList) {
        this.category = prodList.get(0).getCategories();
        this.product = prodList.get(0).getProducts();
        this.email = prodList.get(0).getEmail();
        this.password = prodList.get(0).getPassword();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(MoveMouse.to(HomePage.LEFT_MENU),
                Click.on(HomePage.CELULARES_MENU),
                Scroll.to(CategoriesPage.LBL_CATEGORIES.of(category)),
                Click.on(CategoriesPage.SPAN_PRODUCTS.of(product)),
                Click.on(ProductPage.BTN_ANADIR),
                Click.on(ProductPage.BTN_CONTINUE),
                Click.on(CartPage.BTN_PROCESS),
                Enter.theValue(this.email).into(AccountPage.INPUT_EMAIL),
                Enter.theValue(this.password).into(AccountPage.INPUT_PASSWORD),
                Click.on(AccountPage.BTN_LOGIN)
                );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static SelectProduct prod(List<ProductAndLogin> prodList){
        return Tasks.instrumented(SelectProduct.class, prodList);
    }
}
