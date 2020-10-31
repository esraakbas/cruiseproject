package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
//        System.out.println("This is SetUP Method in the Hooks");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @After
    public void tearDown(Scenario scenario){

        //Taking the screenshot
        final byte[] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        //We are embedding the screenshot as an image in our framework
        //We SHOULD get screenshot after every FAILING Scenario
        //Attaching the image if scenario fails
        if (scenario.isFailed()) {
            scenario.embed(screenshot, "image/png");
        }
//        Driver.closeDriver();
   }

}

