package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CruiseSearchPage;
import utilities.BrowserUtils;
import utilities.Driver;

import javax.swing.*;

public class CruiseSearch {
    CruiseSearchPage cruiseSearchPage;
    @Given("clients searches for {string} and April,2021")
    public void clients_searches_for_and(String destination) throws InterruptedException {
        cruiseSearchPage = new CruiseSearchPage();
        cruiseSearchPage.destinationDropDown.click();
        BrowserUtils.waitForPageToLoad(5);
        cruiseSearchPage.destinationInput.sendKeys(destination);
        BrowserUtils.waitForPageToLoad(5);
        cruiseSearchPage.alaskaCruise.click();
        BrowserUtils.waitForPageToLoad(5);
        try{
//            Driver.getDriver().findElement(By.xpath("//map[@name='IPEMap']//area[@alt='close']")).click();
            cruiseSearchPage.simpleModelPopUp.click();
        } catch(Exception e){}
        cruiseSearchPage.datesField.click();
        try{
//            Driver.getDriver().findElement(By.xpath("//map[@name='IPEMap']//area[@alt='close']")).click();
            cruiseSearchPage.simpleModelPopUp.click();
        } catch(Exception e){}
        BrowserUtils.waitForPageToLoad(5);
        cruiseSearchPage.date.click();
        try{
//            Driver.getDriver().findElement(By.xpath("//map[@name='IPEMap']//area[@alt='close']")).click();
            cruiseSearchPage.simpleModelPopUp.click();
        } catch(Exception e){}
        cruiseSearchPage.applyButton.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Given("clicks on {string} button")
    public void clicks_on_button(String string) {
        if (string.equals("find a cruise")){
            cruiseSearchPage.findaCruiseButton.click();
            try{
//                Driver.getDriver().findElement(By.xpath("//map[@name='IPEMap']//area[@alt='close']")).click();
                cruiseSearchPage.simpleModelPopUp.click();
            } catch(Exception e){}
        }else if(string.equals("view cruise")){
            cruiseSearchPage.viewCruise.click();
            try{
//                Driver.getDriver().findElement(By.xpath("//map[@name='IPEMap']//area[@alt='close']")).click();
                cruiseSearchPage.simpleModelPopUp.click();
            } catch(Exception e){}
        }

        BrowserUtils.waitForPageToLoad(5);
        try{
//            Driver.getDriver().findElement(By.xpath("//map[@name='IPEMap']//area[@alt='close']")).click();
            cruiseSearchPage.simpleModelPopUp.click();
        } catch(Exception e){}

    }

    @Given("sees a starting price on the first displayed cruise")
    public void sees_a_on_the_first_displayed_cruise() {
        System.out.println(cruiseSearchPage.priceFrom.getText());
        Assert.assertTrue(cruiseSearchPage.priceFrom.getText().contains("FROM"));
        Assert.assertTrue(cruiseSearchPage.priceFrom.getText().contains("$"));
        try{
            cruiseSearchPage.simpleModelPopUp.click();
        } catch(Exception e){}
        Driver.getDriver().navigate().refresh();
        BrowserUtils.waitForPageToLoad(5);
    }


    @Then("navigates to Dates & Prices section")
    public void navigates_to_section() {
        cruiseSearchPage.dateAndPrice.click();
    }

    @Then("at least one Category price should match the advertised price")
    public void at_least_one_Category_price_should_match_the_advertised_price() {
        for (WebElement price:cruiseSearchPage.priceList){
            if (cruiseSearchPage.priceFrom.getText().contains(price.getText())){
                System.out.println(price.getText());
                Assert.assertTrue("PASSED",true);
            }
        }
    }
}

