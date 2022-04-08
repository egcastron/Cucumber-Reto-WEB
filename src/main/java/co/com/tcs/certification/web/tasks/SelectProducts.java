package co.com.tcs.certification.web.tasks;

import co.com.tcs.certification.web.models.Products;
import co.com.tcs.certification.web.userinterfaces.CartPage;
import co.com.tcs.certification.web.userinterfaces.CategoriesPage;
import co.com.tcs.certification.web.userinterfaces.HomePage;
import co.com.tcs.certification.web.userinterfaces.ProductPage;
import net.serenitybdd.core.*;
import net.thucydides.core.steps.WaitForBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

public class SelectProducts implements Task {

    private String category0;
    private String product0;
    private String category1;
    private String product1;
    private String category2;
    private String product2;
    private List<Products> listProducts;

    public SelectProducts(List<Products> prodList) {
        this.category0 = prodList.get(0).getCategories();
        this.product0 = prodList.get(0).getProducts();
        this.category1 = prodList.get(1).getCategories();
        this.product1 = prodList.get(1).getProducts();
        this.category2 = prodList.get(2).getCategories();
        this.product2 = prodList.get(2).getProducts();
        this.listProducts = prodList;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int listSize = listProducts.size();
        actor.remember("listSize", listSize);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(MoveMouse.to(HomePage.LEFT_MENU),
                Click.on(HomePage.CELULARES_MENU),
//                Scroll.to(CategoriesPage.LBL_CATEGORIES.of(category0)),
                Click.on(CategoriesPage.SPAN_PRODUCTS.of(product0)),
                Click.on(ProductPage.BTN_ANADIR));
        BrowseTheWeb.as(actor).getDriver().navigate().back();

        String infoProd0 = CategoriesPage.SPAN_PRODUCTS.of(product0).resolveFor(actor).getText();
        actor.remember("infoProd0", infoProd0);

        actor.attemptsTo(MoveMouse.to(HomePage.LEFT_MENU),
                Click.on(HomePage.BELLEZA_MENU),
                Scroll.to(CategoriesPage.LBL_CATEGORIES.of(category1)),
                Click.on(CategoriesPage.SPAN_PRODUCTS.of(product1)),
                Click.on(ProductPage.BTN_ANADIR));
        BrowseTheWeb.as(actor).getDriver().navigate().back();

        String infoProd1 = CategoriesPage.SPAN_PRODUCTS.of(product1).resolveFor(actor).getText();
        actor.remember("infoProd1", infoProd1);

        actor.attemptsTo(MoveMouse.to(HomePage.LEFT_MENU),
                Click.on(HomePage.MODA_MENU),
                Scroll.to(CategoriesPage.LBL_CATEGORIES.of(category2)),
                Click.on(CategoriesPage.SPAN_PRODUCTS.of(product2)),
                Click.on(ProductPage.BTN_ANADIR));
        BrowseTheWeb.as(actor).getDriver().navigate().back();

        String infoProd2 = CategoriesPage.SPAN_PRODUCTS.of(product2).resolveFor(actor).getText();
        actor.remember("infoProd2", infoProd2);

        actor.attemptsTo(Click.on(HomePage.CART));

        String infoCart0 = CartPage.LBL_CART_PROD.of(product0).resolveFor(actor).getText();
        actor.remember("infoCart0", infoCart0);

        String infoCart1 = CartPage.LBL_CART_PROD.of(product1).resolveFor(actor).getText();
        actor.remember("infoCart1", infoCart1);

        actor.attemptsTo(Scroll.to(CartPage.LBL_CART_PROD.of(product1)));
        String infoCart2 = CartPage.LBL_CART_PROD.of(product2).resolveFor(actor).getText();
        actor.remember("infoCart2", infoCart2);
    }


    public static SelectProducts product(List<Products> prodList){
        return Tasks.instrumented(SelectProducts.class, prodList);
    }
}
