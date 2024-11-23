package com.shivaji.beans;
public class WishBean {
    private String name;
    private String wishMessage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWishMessage() {
        return wishMessage;
    }

    public void setWishMessage(String wishMessage) {
        this.wishMessage = wishMessage;
    }
    public String wishUser(){
        return "Hello "+name+","+wishMessage;
    }
}
