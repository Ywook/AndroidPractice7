package com.examples.androidpractice7;

/**
 * Created by Mac on 2017. 4. 27..
 */

public class Fruit {
    private String name;
    private int imgno;
    private String sPrice;
    final static int image[] = {
            R.drawable.abocado,
            R.drawable.watermelon,
            R.drawable.orange,
            R.drawable.kiwi,
            R.drawable.cherry,
            R.drawable.cranberry,
            R.drawable.banana
    };
    String price[] = {
            "1000원",
            "2000원",
            "3000원",
            "4000원",
            "5000원",
            "6000원",
            "7000원"
    };



    public Fruit(String name, int imgno, int p){
        this.name = name;
        this.imgno = imgno;
        this.sPrice = price[p];
    }

    public String getName() {
        return name;
    }

    public String getsPrice() {
        return sPrice;
    }

    public void setsPrice(int i){
        sPrice = price[i];
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgno() {
        return imgno;
    }

    public void setImgno(int imgno) {
        this.imgno = imgno;
    }
}
