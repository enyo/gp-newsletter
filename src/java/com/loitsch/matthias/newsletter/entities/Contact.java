package com.loitsch.matthias.newsletter.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import java.lang.StringBuilder;

import java.util.List;

@PersistenceCapable
public class Contact {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id;
  @Persistent
  private String title;
  @Persistent
  private String firstName;
  @Persistent
  private String middleName;
  @Persistent
  private String lastName;
  @Persistent
  private String email;
  @Persistent
  private String note;
  @Persistent(mappedBy = "contact")
  private List<Address> addresses;
  @Persistent(mappedBy = "contact")
  private List<PhoneNumber> phoneNumbers;

  public Contact(String title, String firstName, String middleName, String lastName, String email, String note) {
    this.title = title;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.email = email;
    this.note = note;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Long getId() {
    return id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public List<PhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Returns a formatted name using the title, first, middle and last name.
   * @return
   */
  public String getFormattedName() {
    StringBuilder sb = new StringBuilder();
    if (!title.isEmpty()) {
      sb.append(title);
      sb.append(" ");
    }

    sb.append(firstName);
    sb.append(" ");
    if (!middleName.isEmpty()) {
      sb.append(middleName);
      sb.append(" ");
    }
    sb.append(lastName);


    return sb.toString();
  }
}
