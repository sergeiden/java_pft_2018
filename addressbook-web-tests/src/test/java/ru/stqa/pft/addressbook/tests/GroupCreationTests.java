package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by serg on 20.07.2018.
 */
public class GroupCreationTests extends TestBase {

  @Test (invocationCount = 1)
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }
}
