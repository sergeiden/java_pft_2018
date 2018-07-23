package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by serg on 21.07.2018.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Modified", "915756900", "Lenina, 20", "Test1"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoGroupPage();
  }
}
