package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

/**
 * Created by serg on 21.07.2018.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  @Test
  public void groupModificationTest() {

    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("Test2").withHeader("TestHeader").withFooter("TestFooter");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(before.size(), after.size());

    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(after, before);
  }
}
