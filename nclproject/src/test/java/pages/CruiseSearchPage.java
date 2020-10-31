package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CruiseSearchPage {
    public CruiseSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[text()='Alaska Cruises']/parent::label")
    public WebElement alaskaCruise;
    @FindBy (xpath = "//input[@type='text' and @placeholder='Find a Destination']")
    public WebElement destinationInput;
    @FindBy(xpath = "//div[@data-code='destination']")
    public WebElement destinationDropDown;
    @FindBy(xpath = "(//div[@class='e1'])[3]")
    public WebElement datesField;
    @FindBy(xpath = "//li[@data-year='2021' and @data-value='April']")
    public WebElement date;
    @FindBy (xpath = "//a[@title='Apply' and @class='link-2']")
    public WebElement applyButton;
    @FindBy(xpath = "//a[@data-action='find-a-cruise']")
    public WebElement findaCruiseButton;
    @FindBy(xpath = "(//div[@class='c629_block'])[1]")
    public WebElement priceFrom;
    @FindBy(xpath = "(//div[@class='c91_cta'])[1]")
    public WebElement viewCruise;
    @FindBy(xpath = "(//*[.='Dates & Prices'])[1]")
    public WebElement dateAndPrice;
    @FindBy(xpath = "//div[@data-js='price']")
    public List<WebElement> priceList;
    @FindBy(xpath = "//a[@id='simplemodal-close-img']")
    public WebElement simpleModelPopUp;
}
