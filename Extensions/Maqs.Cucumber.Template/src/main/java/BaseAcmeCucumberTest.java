import com.cognizantsoftvision.maqs.cucumber.BaseSeleniumCucumber;
import com.cognizantsoftvision.maqs.cucumber.ScenarioContext;
import com.cognizantsoftvision.maqs.selenium.BaseSeleniumTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources"
        ,glue={"com.company.automation.test.stepdefs"}
)
public class BaseAcmeCucumberTest extends BaseSeleniumCucumber {

    public BaseAcmeCucumberTest() {
        ScenarioContext.get(ScenarioContext.MAQS_HOLDER);
    }




}
