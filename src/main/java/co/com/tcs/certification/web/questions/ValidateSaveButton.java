package co.com.tcs.certification.web.questions;

import co.com.tcs.certification.web.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateSaveButton implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return CheckoutPage.BTN_SAVE.resolveFor(actor).isEnabled();
    }

    public static ValidateSaveButton valid(){
        return new ValidateSaveButton();
    }
}
