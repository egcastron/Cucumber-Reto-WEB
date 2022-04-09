package co.com.tcs.certification.web.tasks;

import co.com.tcs.certification.web.models.PersonalInformation;
import co.com.tcs.certification.web.models.ProductAndLogin;
import co.com.tcs.certification.web.userinterfaces.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;

import java.util.List;

public class EntersInformation implements Task {

    private String celular;
    private String direccion;
    private String barrio;
    private String departamento;
    private String municipio;
    private String numeroid;

    public EntersInformation(List<PersonalInformation> info) {
        this.celular = info.get(0).getCelular();
        this.direccion = info.get(0).getDireccion();
        this.barrio = info.get(0).getBarrio();
        this.departamento = info.get(0).getDepartamento();
        this.municipio = info.get(0).getMunicipio();
        this.numeroid = info.get(0).getNumeroid();

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(this.celular).into(CheckoutPage.INPUT_PHONE),
                Enter.theValue(this.numeroid).into(CheckoutPage.INPUT_ID),
                Enter.theValue(this.direccion).into(CheckoutPage.INPUT_ADDRESS),
                Enter.theValue(this.barrio).into(CheckoutPage.INPUT_NEIGHBHD),
                SelectFromOptions.byVisibleText(this.departamento).from(CheckoutPage.SLC_REGION),
                SelectFromOptions.byVisibleText(this.municipio).from(CheckoutPage.SLC_MUNICIP)
        );

    }

    public static EntersInformation personal(List<PersonalInformation> info){
        return Tasks.instrumented(EntersInformation.class, info);
    }
}