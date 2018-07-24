package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Modified", "915756900"
            , "Lenina, 20", "Test1"), true);
    app.getContactHelper().submitContact();
    Assert.assertTrue(app.getContactHelper().isElementPresent(By.id("maintable")));
    app.getNavigationHelper().gotoHomePage();
  }
}
