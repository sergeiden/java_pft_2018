package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by serg on 21.07.2018.
 */
public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() {
    if (!app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData("Test", "Modified",
              "915756900", "Lenina, 20", null), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmContactDeletion();
    app.getNavigationHelper().gotoGroupPage();
  }
}
