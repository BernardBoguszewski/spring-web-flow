package com.example.demo.handlers;

import com.example.demo.models.BillingInfo;
import com.example.demo.models.PersonalInfo;
import com.example.demo.models.RegisterModel;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {

    public RegisterModel init() {
        return new RegisterModel();
    }

    public void addPersonalInfo(RegisterModel registerModel, PersonalInfo personalInfo) {
        registerModel.setPersonalInfo(personalInfo);
    }

    public void addBillingInfo(RegisterModel registerModel, BillingInfo billingInfo) {
        registerModel.setBillingInfo(billingInfo);
    }

    public String saveAll(RegisterModel registerModel, MessageContext error) {
        String transitionValue = "success";

        error.addMessage(new MessageBuilder().error()
                .source("registration")
                .defaultText(String.format("Failed register user with username: %s",
                        registerModel.getPersonalInfo().getUsername())).build());

        transitionValue = "failure";

        return "success";
    }

    public String validatePersonalInfo(PersonalInfo personalInfo, MessageContext error) {
        String transitionValue = "success";

        if (personalInfo.getUsername().equalsIgnoreCase("admin")) {
            error.addMessage(new MessageBuilder().
                    error()
                    .source("username")
                    .defaultText("You are not allowed to use admin as the username!")
                    .build());

            transitionValue = "failure";
        }

        if (!personalInfo.getPassword().equals(personalInfo.getConfirmPassword())) {
            error.addMessage(new MessageBuilder().error().source("confirmPassword")
                    .defaultText("Password not match").build());

            transitionValue = "failure";
        }

        return transitionValue;
    }

    public String validateBilling(BillingInfo billingInfo, MessageContext error) {
        String transitionValue = "success";

        if (billingInfo.getAddress().equalsIgnoreCase("xyz")) {
            error.addMessage(new MessageBuilder().
                    error()
                    .source("address")
                    .defaultText("Invalid address!")
                    .build());

            transitionValue = "failure";
        }

        return transitionValue;
    }
}
