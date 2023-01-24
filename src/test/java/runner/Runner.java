package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber-reports/SMT_RunResults.json"},
        features = "src/test/resources/features/StoreOperator/StockOverview.feature",
        glue= {"stepdefinitions"}
)
public class Runner {}

// /StoreOperator/Issuing.feature
// /StoreOperator/PhysicalCountAndAdjustments.feature