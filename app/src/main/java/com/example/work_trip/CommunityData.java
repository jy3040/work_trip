package com.example.work_trip;

public class CommunityData {
    private String title;
    private String date;
    private String company;
    private String money;
    private String duration;
    private String people;
    private String good;
    private String thema;
    private String content;

    private byte[] img;

    public CommunityData(String title, String date, String company, String money,
                         String duration, String people, String good, byte[] img, String thema, String content){
        this.title = title;
        this.date = date;
        this.company = company;
        this.money = money;
        this.duration = duration;
        this.people = people;
        this.good = good;
        this.img = img;
        this.thema = thema;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getCompany() {
        return company;
    }

    public String getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }

    public String getGood() {
        return good;
    }

    public String getMoney() {
        return money;
    }

    public String getPeople() {
        return people;
    }

    public String getTitle() {
        return title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
