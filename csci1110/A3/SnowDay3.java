package csci1110.A3;
import java.util.*;
import java.util.stream.Collectors;

public class SnowDay3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //System.out.print("What's the name of the ski hill? ");
        String skiHillName = in.nextLine();

        SkiHill skiHill = new SkiHill(skiHillName);

        //System.out.print("How many ski runs from top of hill? ");
        int numberRuns = in.nextInt(); in.nextLine();

        for (int i=1; i<=numberRuns; i++) {
            //System.out.print("Enter run " + i + " info - Level(1-3) Name: ");
            int difficulty = in.nextInt();
            String runName = in.nextLine().trim();
            if (difficulty == 1) {
                skiHill.addSkiRun(new EasyRun(runName));
            }
            else if (difficulty == 2) {
                skiHill.addSkiRun(new MediumRun(runName));
            }
            else {
                skiHill.addSkiRun(new HardRun(runName));
            }
        }
        int skierNum = in.nextInt();
        List<Skier> skiers = new ArrayList<>();
        for(int i = 0; i < skierNum; i++){
            int skierLevel  = in.nextInt();
            String skierName = in.nextLine();
            skiers.add(new Skier(skierName, skierLevel));
        }

        System.out.println("Welcome to " + skiHill.getName() + "!" + "\n");

        for(Skier s : skiers) {
            System.out.println("Welcome " + s.getName() + "\n" +"Your ski level is: " + s.getSkierLevel() + "\n");
            System.out.println("For your level, check out these runs: ");
            List<SkiRun> filtered = new ArrayList<>();
            if (s.getSkierLevel() == 1) {
                filtered = skiHill.getSkiRuns().stream().filter(x -> x.getDifficultyLevel() == 1).collect(Collectors.toList());
            }
            else if(s.getSkierLevel() == 2){
                filtered = skiHill.getSkiRuns().stream().filter(x -> x.getDifficultyLevel() <= 2).collect(Collectors.toList());
            }
            else filtered = skiHill.getSkiRuns();

            for (int i = 0; i < filtered.size(); i++) {
                System.out.println((i+1) + ". " + filtered.get(i).getName() + " (" + filtered.get(i).getSymbol() + " - Level " + filtered.get(i).getDifficultyLevel() + ")");
            }
            System.out.println("");
        }
    }
}

