package com.thakur.appinessassignment.models;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    private String country;

    private String endtime;

    private String sno;
    @SerializedName("num.backers")
    private String numbackers;

    private String blurb;

    private String title;

    private String type;

    private String amtpledged;

    private String url;

    private String by;

    private String currency;

    private String location;

    private String state;

    private String percentagefunded;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getNumbackers() {
        return numbackers;
    }

    public void setNumbackers(String numbackers) {
        this.numbackers = numbackers;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmtpledged() {
        return amtpledged;
    }

    public void setAmtpledged(String amtpledged) {
        this.amtpledged = amtpledged;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPercentagefunded() {
        return percentagefunded;
    }

    public void setPercentagefunded(String percentagefunded) {
        this.percentagefunded = percentagefunded;
    }

    @Override
    public String toString() {
        return "ClassPojo [country = " + country + ", end.time = " + endtime + ", s.no = " + sno + ", num.backers = " + numbackers + ", blurb = " + blurb + ", title = " + title + ", type = " + type + ", amt.pledged = " + amtpledged + ", url = " + url + ", by = " + by + ", currency = " + currency + ", location = " + location + ", state = " + state + ", percentage.funded = " + percentagefunded + "]";
    }
}
