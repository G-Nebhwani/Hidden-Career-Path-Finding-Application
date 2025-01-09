package com.example.elite.Model;

public class CounsellorViewModel {
    String ccName,ccDetail,ccExperience,ccprice,ccrate,ccprofile;


    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public String getCcDetail() {
        return ccDetail;
    }

    public void setCcDetail(String ccDetail) {
        this.ccDetail = ccDetail;
    }

    public String getCcExperience() {
        return ccExperience;
    }

    public void setCcExperience(String ccExperience) {
        this.ccExperience = ccExperience;
    }

    public String getCcprice() {
        return ccprice;
    }

    public void setCcprice(String ccprice) {
        this.ccprice = ccprice;
    }

    public String getCcrate() {
        return ccrate;
    }

    public void setCcrate(String ccrate) {
        this.ccrate = ccrate;
    }

    public String getCcprofile() {
        return ccprofile;
    }

    public void setCcprofile(String ccprofile) {
        this.ccprofile = ccprofile;
    }

    public CounsellorViewModel(String ccName, String ccDetail, String ccExperience, String ccprice, String ccrate, String ccprofile) {
        this.ccName = ccName;
        this.ccDetail = ccDetail;
        this.ccExperience = ccExperience;
        this.ccprice = ccprice;
        this.ccrate = ccrate;
        this.ccprofile = ccprofile;
    }
}
