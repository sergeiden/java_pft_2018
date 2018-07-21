package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Testov", "915756900", "Lenina, 20"));
    app.getContactHelper().submitContact();
    app.getNavigationHelper().gotoGroupPage();
  }
}
