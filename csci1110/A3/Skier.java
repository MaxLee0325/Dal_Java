package csci1110.A3;

public class Skier {

    private String name;
    private int skierLevel;

    public Skier(String name, int skierLevel) {
        this.name = name;
        this.skierLevel = skierLevel;
    }

    public String getName() {
        return name;
    }

    public int getSkierLevel() {
        return skierLevel;
    }

    public boolean canSki(SkiRun skiRun) {
        boolean canSkiRun = false;
        if (this.skierLevel >= skiRun.getDifficultyLevel()) {
            canSkiRun = true;
        }
        return canSkiRun;
    }
}