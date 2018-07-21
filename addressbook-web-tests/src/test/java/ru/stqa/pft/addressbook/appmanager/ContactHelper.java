package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by serg on 21.07.2018.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(ChromeDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobilephone());
    type(By.name("address2"), contactData.getAddress());
  }

  public void submitContact() {
    click(By.name("submit"));
  }
}
