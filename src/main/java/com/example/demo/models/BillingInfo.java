package com.example.demo.models;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class BillingInfo implements Serializable {

    private static final long serialVersionUID = 518422623788681612L;

    @NotBlank
    private String address;

    @NotBlank
    private String zipcode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}