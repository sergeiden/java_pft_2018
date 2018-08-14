package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by serg on 14.08.2018.
 */
public class ContactDetailsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
        app.group().create(new GroupData().withName("Test1"));
      }
      app.contact().create(new ContactData().withName("Test").withLastname("Test2")
              .withHome("915756900").withMobile("90000").withWork("77777777").withAddress("Lenina, 20"), true);
    }
  }

  @Test
  public void testContactDetails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    String contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);

    assertThat(merged(contactInfoFromEditForm), equalTo (cleaned(contactInfoFromDetailsPage)));

  }

  private String merged(ContactData contact) {
    return Stream.of(contact.getName(), contact.getLastname(), contact.getAddress()
            , contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .map(ContactDetailsTests :: cleaned)
            .collect(Collectors.joining(""));
  }

  public static String cleaned(String contactData) {
    return contactData.replaceAll("\\s", "").replaceAll("H:|W:|M:", "").replaceAll("Memberof:Test1", "");
  }
}
