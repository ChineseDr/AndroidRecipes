package com.raymond.basedemo.model;

/**
 * Created by ray on 2017/10/24.
 */

public class Contact {
    private int portrait;
    private String name,phoneNumber;
    private String group;

    public Contact() {
    }

    public Contact(int portrait, String name, String phoneNumber, String group) {
        this.portrait = portrait;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.group = group;
    }

    public int getPortrait() {
        return portrait;
    }

    public void setPortrait(int portrait) {
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
