package csci1110.Labs.Lab4A.P2;

import java.text.DecimalFormat;

public class CookieShop {

    private String shopID;
    private int Sales;
    private static int allSales;
    private static int shopCount = 0;
    private static double price;

    public CookieShop(){
        shopCount++;
        shopID = "C" + shopCount;
        Sales = 0;
    }

    public void sale(){
        Sales++;
        allSales++;
    }

    public int getSales(){return Sales;}
    public String getShopID(){return shopID;}
    public static void setPrice(double money){price = money;}
    public static double getPrice(){return price;}
    public static double getAllSales(){return allSales;}
    public static int getShopCount(){return shopCount;}

    public String toString(){
        double rev = Sales * price;
        DecimalFormat df = new DecimalFormat("0.00");
        return "Shop: " + shopID +  " Sales: " + Sales + " Revenue: $" + df.format(rev);
    }
}
