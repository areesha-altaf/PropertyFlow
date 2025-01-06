package testCases;

import org.testng.annotations.Test;
import pageObjects.BaseTest;
import utils.TestData;

public class AddPropertyTests extends BaseTest {

    @Test(description = "Test 1: Verify that the user can log in", priority = 1)
    public void performLogin() {
        loginObj.navigateToLoginPage(TestData.BASE_URL);
        loginObj.enterEmail(TestData.USERNAME);
        loginObj.enterPassword(TestData.PASSWORD);
        loginObj.performLogin();
    }

    @Test(description = "Test 2: Verify that the user can cancel property creation", priority = 2)
    public void verifyPropertyCancel() {
        propertyObj.verifyPropertyPageElements(TestData.NO_PROPERTY_MSG);
        propertyObj.fillPropertyDetails(TestData.PROPERTY_TITLE,TestData.PROPERTY_DESC,TestData.PROPERTY_RENT);
        propertyObj.clickCancel(TestData.NO_PROPERTY_MSG);
    }

    @Test(description = "Test 3: Verify that the user can create a new property", priority = 3)
    public void verifyAddProperty() {
        propertyObj.verifyPropertyPageElements(TestData.NO_PROPERTY_MSG);
        propertyObj.fillPropertyDetails(TestData.PROPERTY_TITLE,TestData.PROPERTY_DESC,TestData.PROPERTY_RENT);
        propertyObj.clickSubmit();
    }

    @Test(description = "Test 4: Verify that the user can view the newly created property", priority = 4)
    public void verifyNewPropertyCreated() {
        propertyObj.verifyPropertyData(TestData.PROPERTY_TITLE,TestData.PROPERTY_DESC,TestData.PROPERTY_RENT);
    }

    @Test(description = "Test 5: Verify that the user can edit the property", priority = 5)
    public void verifyEditProperty() {
        propertyObj.editProperty(TestData.PROPERTY_TITLE_EDIT,TestData.PROPERTY_DESC_EDIT,TestData.PROPERTY_RENT_EDIT);
        propertyObj.verifyPropertyData(TestData.PROPERTY_TITLE_EDIT,TestData.PROPERTY_DESC_EDIT,TestData.PROPERTY_RENT_EDIT);
    }

    @Test(description = "Test 6: Verify that the user can delete the property", priority = 6)
    public void verifyDeleteProperty() {
        propertyObj.deleteProperty();
        propertyObj.verifyPropertyPageElements(TestData.NO_PROPERTY_MSG);
    }

    @Test(description = "Test 7: Verify that the user can log out", priority = 7)
    public void verifyLogout() {
        propertyObj.clickLogout();
        loginObj.verifyLoginPageElements();
    }

}