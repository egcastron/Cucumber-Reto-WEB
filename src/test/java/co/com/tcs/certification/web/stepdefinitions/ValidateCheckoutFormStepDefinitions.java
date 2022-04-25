package co.com.tcs.certification.web.stepdefinitions;

import co.com.tcs.certification.web.models.PersonalInformation;
import co.com.tcs.certification.web.models.ProductAndLogin;
import co.com.tcs.certification.web.questions.ValidatePhoneField;
import co.com.tcs.certification.web.questions.ValidateSaveButton;
import co.com.tcs.certification.web.tasks.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;


import java.util.List;

public class ValidateCheckoutFormStepDefinitions {

    @When("^the user selects one products from categories and makes login$")
    public void theUserSelectsOneProductsFromCategories(List<ProductAndLogin> arg1){
        OnStage.theActorInTheSpotlight().attemptsTo(SelectProduct.prod(arg1));
    }

    @When("^the user enters its information$")
    public void theUserEntersItsInformation(List<PersonalInformation> info){
        OnStage.theActorInTheSpotlight().attemptsTo(EntersInformation.personal(info));
    }

    @Then("^the user will watch the save button enabled$")
    public void theUserWillWatchTheSaveButtonEnabled(){
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateSaveButton.valid(), Matchers.is(true)));
    }

    @Then("^the user will watch the info in phone field equals to (.*)$")
    public void theUserWillWatchTheInfoInPhoneFieldEqualsTo(String phone){
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidatePhoneField.validPhone(), Matchers.equalTo(phone)));
    }
}
