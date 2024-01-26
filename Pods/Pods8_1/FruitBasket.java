package Pods.Pods8_1;

import java.util.*;

public class FruitBasket{

    private LinkedList<Fruit> basket =  new LinkedList<>();

    public FruitBasket(){}

    public void addFruit(Fruit fruit){
        basket.add(fruit);
    }

    public Fruit takeLastFruit(){
        Fruit a = basket.getLast();
        basket.removeLast();
        return a;
    }

    public String toString(){

        String basketContents = "FRUIT BASKET:\n";

        for (Fruit fruit: basket)
        {
            basketContents += fruit.toString()+"\n";
        }
        return basketContents;
    }
}
