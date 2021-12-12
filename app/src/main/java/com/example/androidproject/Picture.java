package com.example.androidproject;

public class Picture {
    int image;
    int image2;
    String name;
    int price;
    String strPrice;
    String[] description = new String[4];
    public Picture(int image,int image2, String name, int price,String strPrice, String[] description){
        this.description = description;
        this.strPrice = strPrice;
        this.image = image;
        this.image2 = image2;
        this.price = price;
        this.name = name;
    }
    public Picture(String name,int price){
        this.name =name;
        this.price = price;
    }
    public String[] getDescription() {
        return description;
    }
    public int getImageID() {
        return image;
    }
    public int getPrice(){return price;}
    public String getName(){ return name;}
    public String getStrPrice(){return strPrice;};
}
