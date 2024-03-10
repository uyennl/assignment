/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.util.Date;

/**
 *
 * @author PC
 */
/*
	idCustomer int PRIMARY KEY not null IDENTITY(1,1),
	userName varchar(100) not null,
	passWord varchar(100) not null,
	firstName varchar(100) not null,
	lastName varchar(100) not null,
	avatar varchar(255) not null,
	phoneNumber varchar(100) not null,
	dateOfBirth date not null,
	role varchar(100) not null
 */
public class Customer {

    private int idCustomer;
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private String avatar;
    private String phoneNumber;
    private Date dateOfBirth;
    private String role;

    public Customer() {

    }

    public Customer(int id, String userName, String passWord, String role){
        this.idCustomer = id;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        
    }
    public Customer(String userName, String passWord, String firstName, String lastName, String avatar, String phoneNumber, Date dateOfBirth, String role) {
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public Customer(int idCustomer, String userName, String passWord, String firstName, String lastName, String avatar, String phoneNumber, Date dateOfBirth, String role) {
        this.idCustomer = idCustomer;
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer + ", userName=" + userName + ", passWord=" + passWord + ", firstName=" + firstName + ", lastName=" + lastName + ", avatar=" + avatar + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", role=" + role + '}';
    }

}
