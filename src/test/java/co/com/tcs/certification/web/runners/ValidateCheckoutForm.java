package co.com.tcs.certification.web.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\validate_checkout_form.feature",
        glue = "co.com.tcs.certification.web.stepdefinitions",
        tags = "@Sce2",
        snippets = SnippetType.CAMELCASE
)

public class ValidateCheckoutForm {
}
