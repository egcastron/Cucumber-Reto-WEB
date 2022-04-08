package co.com.tcs.certification.web.tasks;

import co.com.tcs.certification.web.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class DeleteProducts implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(CartPage.A_INICIO));

        int sizeList = actor.recall("listSize");

        for (int i = 0; i < sizeList; i++) {
            actor.attemptsTo(Click.on(CartPage.BTN_DELETE));
            BrowseTheWeb.as(actor).getDriver().navigate().back();
            BrowseTheWeb.as(actor).getDriver().navigate().forward();
        }
    }

    public static DeleteProducts delete(){
        return Tasks.instrumented(DeleteProducts.class);
    }
}
