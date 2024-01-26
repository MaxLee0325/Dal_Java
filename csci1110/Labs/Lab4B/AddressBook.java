package csci1110.Labs.Lab4B;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AddressBook {
    private ArrayList<Contact> list;

    public AddressBook(){
        list = new ArrayList<>();
    }

    public ArrayList<Contact> getList(){return list;}

    public String toString(){
        String output = "";
        for(Contact i : list){
            output += (i.toString() + "\n");
        }
        int index = output.lastIndexOf("\n");
        StringBuilder str = new StringBuilder(output);
        str.replace(index, index+1, "");
        return str.toString();
    }

    public void add(Contact newContact){
        if(list.size() == 0){
            list.add(newContact);
        }

        boolean duplicated = false;
        for(Contact i : list){
            if(i.compareTo(newContact) == 0){
                duplicated = true;
            }
        }

        if(!duplicated){
            try {
                for (int i = 0; i <= list.size(); i++) {
                    if (list.get(i).compareTo(newContact) < 0) {
                        continue;
                    } else {
                        list.add(i, newContact);
                        break;
                    }
                }
            } catch(Exception e){
                list.add(list.size(), newContact);
            }
        }
    }

    public int deleteContact(String lastName){
        int count = 0;
        count = (int)list.stream().filter(x -> x.getLastName().equals(lastName)).count();
        list = new ArrayList<Contact>((list.stream().filter(x-> !x.getLastName().equals(lastName)).collect(Collectors.toList())));
        return count;
    }
}
