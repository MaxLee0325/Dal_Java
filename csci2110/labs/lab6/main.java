package csci2110.labs.lab6;

public class main {
    public static void main(String[] args) {
        String str1[] = {"Amar", "Boris", "Charlie", "Dan", "Fujian", "Inder", "Pei", "Travis"};
        String str2[] = {"Alex", "Betty", "Charlie", "Dan", "Travis", "Zola", "Zulu"};

        OrderedList<String> list1 = new OrderedList<>();
        OrderedList<String> list2 = new OrderedList<>();
        for(String i : str1){
            list1.add(i);
        }
        for(String i : str2){
            list2.add(i);
        }
        Merge m = new Merge();
        m.merge(list1, list2).enumerate();
        m.common(list1, list2).enumerate();
        m.difference(list1, list2).enumerate();








    }
}
