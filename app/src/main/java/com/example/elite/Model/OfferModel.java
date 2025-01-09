package com.example.elite.Model;

public class OfferModel {
    String offer_userimg;
    String off_title;
    String off_discription;
    String off_instructor;
    String off_percentage;
    String off_actualprice;
    String off_dicount_price;
    public OfferModel(String offer_userimg, String off_title, String off_discription, String off_instructor, String off_percentage, String off_actualprice, String off_dicount_price) {
        this.offer_userimg = offer_userimg;
        this.off_title = off_title;
        this.off_discription = off_discription;
        this.off_instructor = off_instructor;
        this.off_percentage = off_percentage;
        this.off_actualprice = off_actualprice;
        this.off_dicount_price = off_dicount_price;
    }

    public String getOffer_userimg() {
        return offer_userimg;
    }

    public void setOffer_userimg(String offer_userimg) {
        this.offer_userimg = offer_userimg;
    }

    public String getOff_title() {
        return off_title;
    }

    public void setOff_title(String off_title) {
        this.off_title = off_title;
    }

    public String getOff_discription() {
        return off_discription;
    }

    public void setOff_discription(String off_discription) {
        this.off_discription = off_discription;
    }

    public String getOff_instructor() {
        return off_instructor;
    }

    public void setOff_instructor(String off_instructor) {
        this.off_instructor = off_instructor;
    }

    public String getOff_percentage() {
        return off_percentage;
    }

    public void setOff_percentage(String off_percentage) {
        this.off_percentage = off_percentage;
    }

    public String getOff_actualprice() {
        return off_actualprice;
    }

    public void setOff_actualprice(String off_actualprice) {
        this.off_actualprice = off_actualprice;
    }

    public String getOff_dicount_price() {
        return off_dicount_price;
    }

    public void setOff_dicount_price(String off_dicount_price) {
        this.off_dicount_price = off_dicount_price;
    }
}
