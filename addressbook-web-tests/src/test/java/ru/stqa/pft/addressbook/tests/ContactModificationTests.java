package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by serg on 21.07.2018.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereContact()) {
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
      }
      app.getContactHelper().createContact(new ContactData("Test", "Modified",
              "915756900", "Lenina, 20", "Test1"), true);
    }
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Modified", "915756900", "Lenina, 20", "Test1"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoGroupPage();
  }
}
