package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by serg on 21.07.2018.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
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
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData()
            .withName("Test").withLastname("Modified").withMobilephone("915756900").withAddress("Lenina, 20").withGroup("Test1");
    int index = before.size() - 1;
    app.contact().modify(contact, index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }

}
