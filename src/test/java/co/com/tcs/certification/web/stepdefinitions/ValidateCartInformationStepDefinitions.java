package co.com.tcs.certification.web.stepdefinitions;

import co.com.tcs.certification.web.models.Products;
import co.com.tcs.certification.web.questions.MessageCart;
import co.com.tcs.certification.web.questions.SelectInformation;
import co.com.tcs.certification.web.tasks.CartInformation;
import co.com.tcs.certification.web.tasks.DeleteProducts;
import co.com.tcs.certification.web.tasks.SelectProducts;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class ValidateCartInformationStepDefinitions {

    @Managed
    private WebDriver theBrowser;
    public ChromeOptions options = new ChromeOptions();
    public DesiredCapabilities caps = new DesiredCapabilities();

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(theBrowser)));
        OnStage.theActorCalled("user");
//        theBrowser.manage().window().setSize(new Dimension(1920,1080));
        options.addArguments("--start-maximized");
//        options.addArguments("force-device-scale-factor=0.5");
//        options.addArguments("high-dpi-support=0.5");
//        JavascriptExecutor js = (JavascriptExecutor) theBrowser;
//        js.executeScript("document.body.style.transform='scale(0.7)';");
//        caps.setCapability("resolution", "1024x768");
    }

    @Given("^the user is on the main page$")
    public void theUserIsOnTheMainPage(){
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.linio.com.co/"));
//        JavascriptExecutor js = (JavascriptExecutor) theBrowser;
//        js.executeScript("document.body.style.transform='scale(0.7)';");
    }

    @When("^the user selects products from categories$")
    public void theUserSelectsProductsFromCategories(List<Products> arg1){
        OnStage.theActorInTheSpotlight().attemptsTo(SelectProducts.product(arg1));
    }

    @And("^the user see information in the cart$")
    public void theUserSeeInformationInTheCart(){
        OnStage.theActorInTheSpotlight().attemptsTo(CartInformation.info());
    }

    @Then("^the user is on the cart page and will see the information$")
    public void theUserIsOnTheCartPageAndWillSeeTheInformation(){
        List<String> list = OnStage.theActorInTheSpotlight().recall("carList");
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(SelectInformation.info(), Matchers.equalTo(list)));
    }

    @When("^deletes the products of cart$")
    public void deletesTheProductsOfCart(){
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteProducts.delete());
    }

    @Then("^the user will see the message (.*)$")
    public void theUserWillSeeTheMessage(String message){
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(MessageCart.msg(), Matchers.equalTo(message)));
    }
}
