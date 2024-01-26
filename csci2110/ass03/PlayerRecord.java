package csci2110.ass03;

/**
 * Student name: Yongteng Li
 * Student id: B00940715
 * Course id: csci2110
 * File description: class of PlayerRecord, stores the information about a player's game record
 */
public class PlayerRecord {
    private final String name, position, teamName;
    private final int gamesPlayed, goalsScored, assists, penalMinutes, shotsOnGoal, gameWinningGoals;

    public PlayerRecord(String name, String position, String teamName, int gamesPlayed, int goalsScored, int assists, int penalMinutes, int shotsOnGoal, int gameWinningGoals){
        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.penalMinutes = penalMinutes;
        this.shotsOnGoal = shotsOnGoal;
        this.gameWinningGoals = gameWinningGoals;
    }

    public String getName(){return name;}
    public String getPosition(){return position;}
    public String getTeamName(){return teamName;}
    public int getGamesPlayed(){return gamesPlayed;}
    public int getGoalsScored(){return goalsScored;}
    public int getAssists(){return assists;}
    public int getPenalMinutes(){return penalMinutes;}
    public int getShotsOnGoal(){return shotsOnGoal;}
    public int getGameWinningGoals(){return gameWinningGoals;}

    //additional getter method, return the total points
    public int getPoints(){return goalsScored + assists;}
}
