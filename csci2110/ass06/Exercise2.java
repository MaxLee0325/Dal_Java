package csci2110.ass06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Exercise2 {

    public static int topNum = 1;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        // Prompt the user for the file name containing user information
        System.out.print("Enter a file name for the graph: ");
        String fileName = in.nextLine();

        // Open the specified file for reading
        Scanner fileIn = new Scanner(new File(fileName));

        int node_num = fileIn.nextInt(); //I don't need this variable for my program, just step over it
        //read the file, put the data in the file in a hashmap
        HashMap<String, Node> nodeMap = new HashMap<>();
        Node node1, node2;
        //the key is the character, and the values is the node
        while(fileIn.hasNext()){
            String letter1 = fileIn.next();
            //avoid add node repetitively
            if(!nodeMap.containsKey(letter1)) {
                node1 = new Node(letter1);
                nodeMap.put(letter1, node1);
            }
            else
                node1 = nodeMap.get(letter1);
            //avoid add node repetitively
            String letter2 = fileIn.next();
            if(!nodeMap.containsKey(letter2)) {
                node2 = new Node(letter2);
                nodeMap.put(letter2, node2);
            }
            else
                node2 = nodeMap.get(letter2);
            //build the relationship
            node1.addTo(node2);
            node2.addFrom(node1);
        }

        LinkedList<Node> result = new LinkedList<>();
        LinkedList<Node> nodeList = new LinkedList<>();

        //store the nodes in a list
        for(Map.Entry<String, Node> entry : nodeMap.entrySet()){
            nodeList.add(entry.getValue());
        }

        //recursive call
        topological(nodeList, result);

        //print the result
        System.out.println("Solution:");
        for(Node n : result){
            System.out.print(n.getTopNum() + "  ");
        }
        System.out.println();
        for(Node n : result){
            System.out.print(n.getName() + "  ");
        }
    }

    public static void topological(LinkedList<Node> listIn, LinkedList<Node> listOut){
        //operation, take one node with no predecessor, and remove that node from its children's predecessor list
        for(Node i : listIn){
            if(i.getFrom().isEmpty() && !i.getTaken()){
                i.setTopNum(topNum);
                listOut.add(i);
                i.take();
                for(Node n : i.getTo()){
                    n.getFrom().remove(i);
                }
                break;
            }
        }
        topNum++;
        //stop signal
        if(listIn.size() == listOut.size()) return;
        //recursive call
        topological(listIn, listOut);
    }
}
