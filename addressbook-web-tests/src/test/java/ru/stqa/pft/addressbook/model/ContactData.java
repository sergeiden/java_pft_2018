package ru.stqa.pft.addressbook.model;

public class ContactData {

  private int id;
  private final String name;
  private final String lastname;
  private final String mobilephone;
  private final String address;
  private String group;

  public ContactData(String name, String lastname, String mobilephone, String address, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.lastname = lastname;
    this.mobilephone = mobilephone;
    this.address = address;
    this.group = group;
  }

  public ContactData(int id, String name, String lastname, String mobilephone, String address, String group) {
    this.id = id;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
