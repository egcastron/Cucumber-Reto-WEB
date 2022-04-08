package co.com.tcs.certification.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.ArrayList;
import java.util.List;

public class CartInformation implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> listCartInfo = new ArrayList<>();

        listCartInfo.add(actor.recall("infoCart0").toString());
        listCartInfo.add(actor.recall("infoCart1").toString());
        listCartInfo.add(actor.recall("infoCart2").toString());

        actor.remember("cartList", listCartInfo);
    }
    public static CartInformation info(){
        return Tasks.instrumented(CartInformation.class);
    }
}
