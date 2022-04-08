package co.com.tcs.certification.web.questions;

import co.com.tcs.certification.web.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MessageCart implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(CartPage.H2_MSG_EMPTY).viewedBy(actor).asString();
    }

    public static MessageCart msg(){
        return new MessageCart();
    }
}
