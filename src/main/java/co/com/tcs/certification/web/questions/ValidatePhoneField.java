package co.com.tcs.certification.web.questions;

import co.com.tcs.certification.web.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;

public class ValidatePhoneField implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Value.of(CheckoutPage.INPUT_PHONE).viewedBy(actor).asString();
    }

    public static ValidatePhoneField validPhone(){
        return new ValidatePhoneField();
    }
}
