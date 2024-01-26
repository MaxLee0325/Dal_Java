package csci2110.ass05;
/*
Student name: Yongteng Li
Student id: B00940715
Course: csci2110
Project: assignment 5
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Huffman {
    //global variable that validates the input
    static boolean valid = true;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        Scanner keyIn = new Scanner(System.in);
        //prompt to input the file name
        System.out.printf("Huffman Coding\nEnter the name of the file with letters and probability: ");
        String fileName = keyIn.nextLine();

        //store the characters and their probabilities in a linked list
        Scanner fileIn = new Scanner(new File(fileName));
        LinkedList<BinaryTree<Pair>> pairList = new LinkedList<>();

        //read the data from the file and store it in a linked list of binary tree
        while(fileIn.hasNext()){
            Pair pair = new Pair(fileIn.next().charAt(0), Double.parseDouble(fileIn.next()));
            BinaryTree<Pair> t = new BinaryTree<>();
            t.makeRoot(pair);
            pairList.add(t);
        }

        //build the Huffman tree using the list containing the data
        BinaryTree<Pair> tree = buildHuffman(pairList);
        String[] huffmanEncode = new String[26];

        //just a message presented to show the process is being done
        System.out.print("Building the Huffman tree");
        for(int i = 0; i < 3; i++) {
            Thread.sleep(500);  //show the process in a more natural way
            System.out.print(".");
        }

        //generate the Huffman encode for all the character from the tree
        generateCode(tree, huffmanEncode, "");
        System.out.printf("\nHuffman coding completed.\n");

        //prompt to enter a line
        System.out.println("Enter a line(upper case letters only): ");
        String line = keyIn.nextLine();
        String code = "";

        //array that stores the code by character
        String[] lineCode = new String[line.length()];
        //generate the code for the line, and store the code in the array
        code = getCode(huffmanEncode, line, code, lineCode);
        //stop the program if the input is not valid
        if(!valid) return;
        System.out.println("Here's the encoded line: " + code);
        //decode the string, using Huffman code array and the code of the characters
        String decode = decode(huffmanEncode, lineCode);
        System.out.println("The decoded line is: " + decode);
        fileIn.close();
        keyIn.close();
    }

    /**
     * Builds a Huffman tree from a list of binary trees representing individual characters.
     * @param list The list of binary trees representing characters and their frequencies.
     * @return The Huffman tree representing the optimal encoding.
     */
    public static BinaryTree<Pair> buildHuffman(LinkedList<BinaryTree<Pair>> list){
        //take the first two nodes and create a parent node of them
        BinaryTree<Pair> t1 = list.removeFirst();
        BinaryTree<Pair> t2 = list.removeFirst();

        //make a new node
        Pair p3 = new Pair('$', t1.getData().getP() + t2.getData().getP());
        //turn the node into a tree
        BinaryTree<Pair> t3 = new BinaryTree<>();
        t3.makeRoot(p3);

        //attach them together
        t3.attachLeft(t1);
        t3.attachRight(t2);

        //check the list, stop recursion when the list is empty
        if(list.size() == 0) return t3;
        //add the new node into the list in a sorted manner
        list.addLast(t3);
        list.sort(Comparator.comparing(e -> e.getData().getP()));

        return buildHuffman(list);
    }

    /**
     * Recursively generates Huffman codes for each character in the Huffman tree.
     * @param t The current node in the Huffman tree.
     * @param codes An array to store the generated Huffman codes for each character.
     * @param code The current Huffman code being constructed.
     */
    public static void generateCode(BinaryTree<Pair> t, String[] codes, String code){
        //stop the recursion when the leaf node is reached
        if(t.getLeft() == null && t.getRight() == null){
            codes[t.getData().getChar() - 65] = code;
        }
        //get to every leaf node recursively
        else{
            generateCode(t.getLeft(), codes, code + "0");
            generateCode(t.getRight(), codes, code + "1");
        }
    }

    /**
     * Encodes a given line of characters using the provided Huffman encoding.
     * @param huffmanEncode The array of Huffman codes for each character.
     * @param line The input line to be encoded.
     * @param code The encoded representation of the input line.
     * @param lineCode An array to store individual Huffman codes for each character in the line.
     * @return The encoded representation of the input line.
     */
    private static String getCode(String[] huffmanEncode, String line, String code, String[] lineCode) {
        for(int i = 0; i < line.length(); i++){
            //if there is a space, just store a space
            if(line.charAt(i) == ' ') {
                code += " ";
                lineCode[i] = " ";
            }
            //validate the input
            else if(line.charAt(i) < 65 || line.charAt(i) > 90){
                System.out.println("Your input is not valid!");
                valid = false;
                return "";
            }
            //not a space, store the Huffman code according to ascii value
            else{
                code += huffmanEncode[line.charAt(i) - 65];
                lineCode[i] = huffmanEncode[line.charAt(i) - 65];
            }
        }
        return code;
    }

    /**
     * Decodes an encoded message using the provided Huffman encoding.
     * @param huffman The array of Huffman codes for each character.
     * @param code The encoded message to be decoded.
     * @return The decoded message.
     */
    public static String decode(String[] huffman, String[] code){
        String word = "";
        for(int i = 0; i < code.length; i++){
            //if the encoding is a space, means no encoding, just a space
            if(code[i] == " ")
                word += " ";
            else{
                //if not a space, find the match in the Huffman list and get the character
                for(int j = 0; j < 26; j++){
                    if(huffman[j].equals(code[i])){
                        word += (char)(65 + j);
                        break;
                    }
                }
            }
        }
        return word;
    }
}
