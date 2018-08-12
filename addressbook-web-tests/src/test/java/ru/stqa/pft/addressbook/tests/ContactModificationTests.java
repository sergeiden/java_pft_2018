package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by serg on 21.07.2018.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
        app.group().create(new GroupData().withName("Test1"));
      }
      app.contact().create(new ContactData()
              .withName("Test").withLastname("Testov").withMobilephone("915756900").withAddress("Lenina, 20"), true);
    }
  }

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withName("Test").withLastname("Modified").withMobilephone("915756900").withAddress("Lenina, 20").withGroup("Test1");
    app.contact().modify(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();

    Assert.assertEquals(after, before);

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
