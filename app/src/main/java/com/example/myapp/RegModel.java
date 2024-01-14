package com.example.myapp;


public class RegModel
{
    public String getFullName() {
        return fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    private String fullName,mobile,email,pass;

    RegModel()
    {

    }
    RegModel(String fullName,String mobile,String email,String pass)
    {
        this.fullName=fullName;
        this.mobile=mobile;
        this.email=email;
        this.pass=pass;


    }


}


