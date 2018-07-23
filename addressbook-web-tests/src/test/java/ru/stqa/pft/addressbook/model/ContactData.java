package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String mobilephone;
  private final String address;
  private String group;

  public ContactData(String name, String lastname, String mobilephone, String address, String group) {
    this.name = name;
    this.lastname = lastname;
    this.mobilephone = mobilephone;
    this.address = address;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getAddress() {
    return address;
  }

  public String getGroup() {
    return group;
  }
}
