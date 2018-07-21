package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String mobilephone;
  private final String address;

  public ContactData(String name, String lastname, String mobilephone, String address) {
    this.name = name;
    this.lastname = lastname;
    this.mobilephone = mobilephone;
    this.address = address;
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
}
