package csci1110.Labs.Lab4A.P2;
import java.text.DecimalFormat;
import java.util.*;

public class CookieShopDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double price = in.nextDouble();
        int length = in.nextInt();
        int totalSales = in.nextInt();
        double totalRev = 0;
        CookieShop[] shops = new CookieShop[length];
        for(int i = 0; i < length; i++){
            shops[i] = new CookieShop();
            shops[i].setPrice(price);
        }
        for(int i = 0; i < totalSales; i++){
            int index = in.nextInt();
            for(int j = 0; j < length; j++){
                if(index == j){
                    shops[j].sale();
                }
            }
        }
        for(CookieShop i : shops){
            System.out.println(i.toString());
            totalRev += (i.getPrice() * i.getSales());
        }
        int top = 0;
        for(int i = 0; i < length-1; i++){
            if(shops[i+1].getSales() > shops[top].getSales()){
                top = i + 1;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Total cookies sold in all shops: " + totalSales);
        System.out.println("Total revenue from all shops: $ " + df.format(totalRev));
        System.out.println("There are " + length + " Cookie shops.");
        System.out.println("The top shops is: " + shops[top].getShopID());
    }
}
