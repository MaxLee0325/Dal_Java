package Pods.Pod11_1;

public class Banana {

    private boolean isRipe;
    private boolean isRotten;

    public Banana (boolean isRipe, boolean isRotten) {
        this.isRipe = isRipe;
        this.isRotten = isRotten;
    }

    public boolean getIsRipe() {
        return this.isRipe;
    }

    public boolean getIsRotten() {
        return this.isRotten;
    }

    public void setIsRipe(boolean ripe) {
        this.isRipe = ripe;
    }

    public void setIsRotten(boolean rotten) {
        this.isRotten = rotten;
    }

    public String toString() {
        return "Banana: ripe="+this.isRipe+" rotten="+this.isRotten;
    }
}