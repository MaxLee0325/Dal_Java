package csci2110.labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Merge {
    public static void main(String[] args) {

        ArrayList<String> nameList = new ArrayList<>();
        try{
        File names = new File("/Users/maxlee/IdeaProjects/untitled/src/csci2110/labs/lab6/RandomNames.txt");
        Scanner in = new Scanner(names);
            while(in.hasNext()){
                nameList.add(in.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);;
        }

        System.out.println("Enter a integer between 1000 and 1500 to generate list1");
        Scanner in1 = new Scanner(System.in);
        int numList1 = in1.nextInt();
        OrderedList<String> list1 = listGenerator(nameList, numList1);

        System.out.println("Enter a integer between 1000 and 1500 to generate list2");
        Scanner in2 = new Scanner(System.in);
        int numList2 = in2.nextInt();
        OrderedList<String> list2 = listGenerator(nameList, numList2);

//        list1.enumerate();    //for test purpose
//        list2.enumerate();    //for test purpose

        merge(list1, list2).enumerate();
        common(list1, list2).enumerate();
        difference(list1, list2).enumerate();
    }

    /**
     * Generate an OrderList from the input arraylist with the length of the input integer
     * @param list
     * @param numOfList
     * @return
     * @param <T>
     */
    public static <T extends Comparable<T>> OrderedList<T> listGenerator(ArrayList<T> list, int numOfList){
        OrderedList<T> listOut = new OrderedList<T>();
        for(int i = 0; i < numOfList; i++){
            Random ran = new Random();
            int idx = (int)(2000 * ran.nextDouble());
            if(idx == 2000) idx--;
            listOut.insert(list.get(idx));
        }
        return listOut;
    }


    /**
     * Merge list1 and list2 by order
     * @param list1
     * @param list2
     * @return
     * @param <T>
     */
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> list3 = new OrderedList<>();
        int idxF1 = 0, idxF2 = 0;

        while(idxF1 < list1.size() && idxF2 < list2.size()){
            T f1 = list1.get(idxF1);
            T f2 = list2.get(idxF2);
            if(f1.compareTo(f2) < 0){
                list3.add(f1);
                idxF1++;
            }
            else if(f1.compareTo(f2) > 0){
                list3.add(f2);
                idxF2++;
            }
            else{
                list3.add(f1);
                idxF1++;
                idxF2++;
            }
        }

        if(idxF1 == list1.size()){
            for(int i = idxF2; i < list2.size(); i++){
                list3.add(list2.get(i));
            }
        }
        else{
            for(int i = idxF1; i < list1.size(); i++){
                list3.add(list1.get(i));
            }
        }
        return list3;
    }

    /**
     * Find the common elements in list1 and list2
     * @param list1
     * @param list2
     * @return
     * @param <T>
     */
    public static <T extends Comparable<T>> OrderedList<T> common(OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> list3 = new OrderedList<>();
        int idxF1 = 0, idxF2 = 0;

        while(idxF1 < list1.size() && idxF2 < list2.size()){
            T f1 = list1.get(idxF1);
            T f2 = list2.get(idxF2);
            if(f1.compareTo(f2) < 0){
                idxF1++;
            }
            else if(f1.compareTo(f2) > 0){
                idxF2++;
            }
            else{
                list3.add(f1);
                idxF1++;
                idxF2++;
            }
        }
        return list3;
    }

    /**
     * Find the elements inside list1 but not in list2
     * @param list1
     * @param list2
     * @return
     * @param <T>
     */
    public static <T extends Comparable<T>> OrderedList<T> difference(OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> list3 = new OrderedList<>();
        int idxF1 = 0, idxF2 = 0;

        while(idxF1 < list1.size() && idxF2 < list2.size()){
            T f1 = list1.get(idxF1);
            T f2 = list2.get(idxF2);
            if(f1.compareTo(f2) < 0){
                list3.add(f1);
                idxF1++;
            }
            else if(f1.compareTo(f2) > 0){
                idxF2++;
            }
            else{
                idxF1++;
                idxF2++;
            }
        }

        if(idxF2 == list2.size()){
            for(int i = idxF1; i < list1.size(); i++){
                list3.add(list1.get(i));
            }
        }
        return list3;
    }
}
