package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by serg on 21.07.2018.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Test").withLastname("Test2")
              .withHome("915756900").withMobile("90000").withWork("77777777").withAddress("Lenina, 20"), true);
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact.getId());
    app.goTo().homePage();
    Contacts after = app.contact().all();

    assertThat(after.size(), equalTo(before.size() - 1));

    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
