package com.example.demo.models;

import java.io.Serializable;

public class RegisterModel implements Serializable {

    private static final long serialVersionUID = -5963739354504497135L;

    private PersonalInfo personalInfo;
    private BillingInfo billingInfo;

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }
}