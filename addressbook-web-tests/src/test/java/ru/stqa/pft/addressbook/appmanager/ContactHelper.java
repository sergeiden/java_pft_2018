package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by serg on 21.07.2018.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contact, boolean creation) {
    type(By.name("firstname"), contact.getName());
    type(By.name("lastname"), contact.getLastname());
    attach(By.name("photo"), contact.getPhoto());
    type(By.name("home"), contact.getHomePhone());
    type(By.name("mobile"), contact.getMobilePhone());
    type(By.name("work"), contact.getWorkPhone());
    if (creation) {
      if (contact.getGroup() != null) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contact.getGroup());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("address"), contact.getAddress());
  }

  public void submitContact() {
    click(By.name("submit"));
  }

  public void editContact(int id) {
//    WebElement element = wd.findElement(By.cssSelector("input[value = '" + id + "']"));
//    element.findElement(By.xpath("//img[@alt='Edit']")).click();
    wd.findElement(By.cssSelector(String.format("a[href = 'edit.php?id=%s']", id))).click();

  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void confirmContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContact();
    contactCache = null;
  }

  public void delete(int id) {
    selectContactById(id);
    deleteContact();
    confirmContactDeletion();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    editContact(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
  }

  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  private Contacts contactCache = null;


  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    Contacts contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      contactCache.add(new ContactData().withId(id).withName(name).withLastname(lastname).withAllPhones(allPhones));
    }
    return contactCache;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    editContact(contact.getId());
    String name = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId()).withName(name).withLastname(lastname).withHome(home).withMobile(mobile).withWork(work).withAddress(address);
  }

  public String infoFromDetailsPage(ContactData contact) {
    wd.findElement(By.cssSelector(String.format("a[href = 'view.php?id=%s']", contact.getId()))).click();
    return wd.findElement(By.id("content")).getText();
  }
}
