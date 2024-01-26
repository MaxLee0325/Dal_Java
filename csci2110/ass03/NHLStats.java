package csci2110.ass03;
/**
 * Student name: Yongteng Li
 * Student id: B00940715
 * Course id: csci2110
 * File description: class of NHLStats, it is essentially an extension of a linkedlist, with additional functions to retrieve the information we want
 */
import java.io.PrintWriter;
import java.util.*;

public class NHLStats {
    private LinkedList<PlayerRecord> list;
    private PrintWriter out;

    //the constructor takes in a print writer in order to output to a file according to the demo class
    public NHLStats(PrintWriter out){
        this.list = new LinkedList<>();
        this.out = out;
    }

    //three basic list functions
    public void add(PlayerRecord record){
        list.add(record);
    }
    public boolean isEmpty(){return list.isEmpty();}
    public int size(){return list.size();}

    /**
     * getMostPoints() method loops through the list to find the highest points and print out the player name and team name
     */
    public void getMostPoints(){
        int max = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.getAt(i).getPoints() > max) {
                max = list.getAt(i).getPoints();
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(list.getAt(i).getPoints() == max)
                out.printf("Player name: %s, team name: %s.\n", list.getAt(i).getName(), list.getAt(i).getTeamName());
        }
    }

    /**
     * getMostAggressive method loops through the list to find the highest penalty minutes and print out the player name, team name and position
     */
    public void getMostAggressive(){
        int max = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.getAt(i).getPenalMinutes() > max) {
                max = list.getAt(i).getPenalMinutes();
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(list.getAt(i).getPenalMinutes() == max)
                out.printf("Player name: %s, team name: %s, position: %s.\n", list.getAt(i).getName(), list.getAt(i).getTeamName(), list.getAt(i).getPosition());
        }
    }

    /**
     * getMVP method loops through the list to find the highest gameWinningGoals and print out the player name and team name
     */
    public void getMVP(){
        int max = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.getAt(i).getGameWinningGoals() > max) {
                max = list.getAt(i).getGameWinningGoals();
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(list.getAt(i).getGameWinningGoals() == max)
               out.printf("Player name: %s, team name: %s.\n", list.getAt(i).getName(), list.getAt(i).getTeamName());
        }
    }

    /**
     * getPromising method loops through the list to find the highest shotsOnGoal and print out the player name and team name
     */
    public void getPromising(){
        int max = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.getAt(i).getShotsOnGoal() > max) {
                max = list.getAt(i).getShotsOnGoal();
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(list.getAt(i).getShotsOnGoal() == max)
                out.printf("Player name: %s, team name: %s.\n", list.getAt(i).getName(), list.getAt(i).getTeamName());
        }
    }

    /**
     * getMostAggressiveTeam method, first store all the distinct team names, then calculate the total penalty minutes of each team, lastly find the team with most penalty minutes
     */
    public void getMostAggressiveTeam(){
        //use stack tp store the distinct team names
        Stack<String> teamNames = findTeamName();
        //use hashmap tp store the penalty time of each team
        HashMap<String, Integer> teamMap = new HashMap<>();
        for(String i : teamNames){
            int totalPenalty = 0;
            //use linked list to store all the players of each team
            LinkedList<PlayerRecord> teamMembers = findRecord(i);
            //sum up the total penalty minutes
            for(int j = 0; j < teamMembers.size(); j++){
                totalPenalty += teamMembers.getAt(j).getPenalMinutes();
            }
            teamMap.put(i, totalPenalty);
        }
        //call the method to find and print the highest values in the hashmap
        findMostValues(teamMap);
    }

    /**
     * getMostWinningTeam method, first store all the distinct team names, then calculate the total winning goals of each team, lastly find the team with most winning goals
     */
    public void getMostWinningTeam(){
        //use stack tp store the distinct team names
        Stack<String> teamNames = findTeamName();
        //use hashmap tp store the penalty time of each team
        HashMap<String, Integer> teamMap = new HashMap<>();
        for(String i : teamNames){
            int totalWinningGoals = 0;
            //use linked list to store all the players of each team
            LinkedList<PlayerRecord> teamMembers = findRecord(i);
            //sum up the total winning goals
            for(int j = 0; j < teamMembers.size(); j++){
                totalWinningGoals += teamMembers.getAt(j).getGameWinningGoals();
            }
            teamMap.put(i, totalWinningGoals);
        }
        //call the method to find and print the highest values in the hashmap
        findMostValues(teamMap);
    }

    /**
     * findRecord method takes in a string of the team name, and find the team name in the list that matches the input name
     * @param teamName a string of the team name
     * @return a LinkedList that contains all the player record with the team name
     */
    public LinkedList<PlayerRecord> findRecord(String teamName){
        LinkedList<PlayerRecord> records = new LinkedList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.getAt(i).getTeamName().equals(teamName)){
                records.add(list.getAt(i));
            }
        }
        return records;
    }

    /**
     * findTeamName method find the unique team names in the player record list
     * @return a stack that contains all the team names
     */
    public Stack<String> findTeamName(){
        Stack<String> names = new Stack<>();
        for(int i = 0; i < list.size(); i++){
            names.add(list.getAt(i).getTeamName());
        }
        return names;
    }

    /**
     * findMostValues method takes in a hashmap, then find the largest value in the map, then print all the keys that has that value
     * @param map a hashmap with the team names as keys and values
     */
    public void findMostValues(HashMap<String, Integer> map){
        int max = 0;
        for(Map.Entry<String, Integer> i : map.entrySet()){
            if(i.getValue() > max){
                max = i.getValue();
            }
        }
        for(Map.Entry<String, Integer> i : map.entrySet()){
            if(i.getValue() == max){
                out.printf("Team: %s.\n", i.getKey());
            }
        }
    }
}
