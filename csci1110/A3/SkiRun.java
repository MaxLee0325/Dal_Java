package csci1110.A3;

public class SkiRun {
    private String name;
    private String symbol;
    private int difficultyLevel;

    private boolean runIsOpen;

    public SkiRun(String name, String symbol, int difficultyLevel){
        this.name = name;
        this.symbol = symbol;
        this.difficultyLevel = difficultyLevel;
    }

    public String getName(){return name;}
    public String getSymbol(){return symbol;}
    public int getDifficultyLevel(){return difficultyLevel;}
    public boolean isOpen(){return runIsOpen;}

    public void openRun(){
        runIsOpen = true;
    }
    public void closeRun(){
        runIsOpen = false;
    }
}