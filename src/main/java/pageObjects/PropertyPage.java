package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ReusableFunctions;

import java.util.List;

public class PropertyPage {
    private WebDriver driver;
    // Locators
    @FindBy(css = "button:nth-child(1)")
    private WebElement addPropertyBtn;

    @FindBy(css = "button:nth-child(2)")
    private WebElement logoutBtn;

    @FindBy(tagName = "p")
    private WebElement noPropertyMsg;

    @FindBy(css = "input[placeholder=Title]")
    private WebElement title;

    @FindBy(css = "input[placeholder=Description]")
    private WebElement description;

    @FindBy(css = "input[placeholder=Rent]")
    private WebElement rent;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitBtn;

    @FindBy(tagName = "h3")
    private WebElement propertyTitle;

    @FindBy(tagName = "p")
    private List<WebElement> propertyDetail;

    @FindBy(xpath = "//button[text()='Edit']")
    private WebElement editBtn;

    @FindBy(css = "input[type=text]")
    private List<WebElement> textEditFields;

    @FindBy(css = "input[type=number]")
    private WebElement rentEdit;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement deleteBtn;

    public PropertyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize page elements
    }

    public void verifyPropertyPageElements(String noPropText){
        ReusableFunctions.waitForSeconds(500);
        Assert.assertTrue(addPropertyBtn.isEnabled());
        Assert.assertTrue(logoutBtn.isEnabled());
        Assert.assertTrue(noPropertyMsg.getText().contains(noPropText));
    }

    public void fillPropertyDetails(String pTitle, String pDesc, String pRent){
        addPropertyBtn.click();
        title.sendKeys(pTitle);
        description.sendKeys(pDesc);
        rent.sendKeys(pRent);
    }

    public void clickCancel(String noPropText){
        cancelBtn.click();
        Assert.assertTrue(noPropertyMsg.getText().contains(noPropText));
    }

    public void clickSubmit(){
        submitBtn.click();
//        ReusableFunctions.waitForSeconds(500);
    }

    public void verifyPropertyData(String expTitle, String expDesc, String expRent){
        ReusableFunctions.waitForSeconds(500);
        Assert.assertEquals(propertyTitle.getText(),expTitle);
        Assert.assertEquals(propertyDetail.get(0).getText(),expDesc);
        Assert.assertTrue(propertyDetail.get(1).getText().contains(expRent));
    }

    public void editProperty(String title, String desc, String rent){
        ReusableFunctions.waitForSeconds(500);
        editBtn.click();
        textEditFields.get(0).clear();
        textEditFields.get(0).sendKeys(title);
        textEditFields.get(1).clear();
        textEditFields.get(1).sendKeys(desc);
        rentEdit.clear();
        rentEdit.sendKeys(rent);
        saveBtn.click();
        ReusableFunctions.waitForSeconds(3000);
    }

    public void deleteProperty(){
        deleteBtn.click();
    }

    public void clickLogout(){
        logoutBtn.click();
    }
}
