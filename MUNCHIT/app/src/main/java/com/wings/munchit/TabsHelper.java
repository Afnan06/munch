package com.wings.munchit;

public class TabsHelper {

    private int photo;
    private String Foodname;
    private int Foodprice;
    private String Descrption;




    public TabsHelper(String foodname, int foodprice,String descrption, int photo) {
        this.photo = photo;
        this.Foodname=foodname;
        this.Foodprice=foodprice;
        this.Descrption=descrption;

    }
    //getter

    public int getPhoto() {
        return photo;
    }
    public String getFoodname() {
        return Foodname;
    }

    public int getFoodprice() {
        return Foodprice;
    }
    public String getDescrption() {
        return Descrption;
    }


    //setter

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setFoodname(String foodname) {
        Foodname = foodname;
    }
    public void setDescrption(String descrption) {
        Descrption = descrption;
    }

    public void setFoodprice(int foodprice) {
        Foodprice = foodprice;
    }
}
