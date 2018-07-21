package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by serg on 21.07.2018.
 */
public class ContactRemovalTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmContactRemoval();
    app.getNavigationHelper().gotoGroupPage();
  }
}
