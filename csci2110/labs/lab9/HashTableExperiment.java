package csci2110.labs.lab9;//Hash Table Experiment
//This is a simple demo program that
//creates an ArrayList of LinkedList of Integer objects
//It first displays the empty linked lists
//It then hashes some keys and displays the linked lists again
//It uses the generic LinkedList class and the generic Node class

//MODIFY THIS PROGRAM TO DO THE LAB EXERCISE 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
public class HashTableExperiment
{
	public static void main(String[] args)
	{
		//prompt the user to enter the table size
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the hash table size: ");
		int n = keyboard.nextInt();
		
		//create an Arraylist of size n
		//The ArrayList holds a LinkedList object 
		//The LinkedList consists of nodes that hold integer objects
		ArrayList<LinkedList<Integer>> hashtable = new ArrayList<LinkedList<Integer>>();
		for (int i=0; i<n; i++)
		{
			hashtable.add(i, new LinkedList<Integer>());
		}
		//Display the arraylist of linked lists
		System.out.println("Empty lists");
		for (int i=0; i<n; i++)
		{
			System.out.print(i + ": ");
			hashtable.get(i).enumerate();
			System.out.println("null");
		}

		System.out.printf("Enter the number of keys: ");
		int num = keyboard.nextInt();
		//generate random non-duplicated keys
		int max = 10000;
		HashSet<Integer> keySet = new HashSet<>();
		while(keySet.size() < num){
			Random ran = new Random();
			double r = ran.nextDouble();
			int key = (int)(r * max);
			keySet.add(key);
		}

		//hash the keys into the table, and keep count of collisions
		int collisions = 0;
		for(int i : keySet){
			int idx = i%n;
			LinkedList<Integer> list = hashtable.get(idx);
			collisions += (!list.isEmpty()) ? 1 : 0;
			list.add(i);
		}

		//find the max length
		int maxLen = 0;
		for(LinkedList<Integer> list : hashtable){
			if(list.size() > maxLen)
				maxLen = list.size();
		}

		//Display the arraylist of linked lists
		System.out.println();
		System.out.println("After the keys are hashed");

		for (int i=0; i<n; i++)
		{
			System.out.print(i + ": ");
			hashtable.get(i).enumerate();
			System.out.println("--> null");
		}

		System.out.printf("\nStatistics:\n\n");
		System.out.printf("Table size: %d\n", n);
		System.out.printf("Number of keys: %d\n", num);
		System.out.printf("Load factor: %.2f\n\n", ((float)num/(float)n));
		System.out.printf("Number of collisions: %d\n", collisions);
		System.out.printf("Longest list: %d\n\n", maxLen);
	}
}
			
		
