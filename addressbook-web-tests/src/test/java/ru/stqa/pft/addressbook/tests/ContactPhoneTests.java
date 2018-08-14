package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by serg on 13.08.2018.
 */
public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactsPhone() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests :: cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()+]", "");
  }
}
