package com.example.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class FormController {
    private String name;
    private String regNumber;
    private String password;
    private String gender;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


   public FormController(){

    }

    public FormController(String name, String regNumber, String password, String gender) {
        this.name = name;
        this.regNumber = regNumber;
        this.password = password;
        this.gender = gender;
    }

    public void saveForm() {
        DatabaseConnector connector = new DatabaseConnector();
        connector.saveFormData(name, regNumber, password, gender);
    }


}
