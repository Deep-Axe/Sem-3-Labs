import java.util.Scanner;

interface Sports {
    int getNumberOfGoals();
    void dispTeam();
}

class Hockey implements Sports {
    private String team1;
    private String team2;
    private int goalsTeam1;
    private int goalsTeam2;

    public Hockey(String team1, String team2, int goalsTeam1, int goalsTeam2) {
        this.team1 = team1;
        this.team2 = team2;
        this.goalsTeam1 = goalsTeam1;
        this.goalsTeam2 = goalsTeam2;
    }
    @Override
    public int getNumberOfGoals() {
        return goalsTeam1 + goalsTeam2;
    }

    @Override
    public void dispTeam() {
        System.out.println("Hockey Match:");
        System.out.println(team1 + " vs " + team2);
        System.out.println("Goals: " + team1 + " " + goalsTeam1 + " - " + team2 + " " + goalsTeam2);
        System.out.println("Winning Team: " + (goalsTeam1 > goalsTeam2 ? team1 : goalsTeam1 < goalsTeam2 ? team2 : "Draw"));
    }
}

class Football implements Sports {
    private String team1;
    private String team2;
    private int goalsTeam1;
    private int goalsTeam2;

    public Football(String team1, String team2, int goalsTeam1, int goalsTeam2) {
        this.team1 = team1;
        this.team2 = team2;
        this.goalsTeam1 = goalsTeam1;
        this.goalsTeam2 = goalsTeam2;
    }

    @Override
    public int getNumberOfGoals() {
        return goalsTeam1 + goalsTeam2;
    }

    @Override
    public void dispTeam() {
        System.out.println("Football Match:");
        System.out.println(team1 + " vs " + team2);
        System.out.println("Goals: " + team1 + " " + goalsTeam1 + " - " + team2 + " " + goalsTeam2);
        System.out.println("Winning Team: " + (goalsTeam1 > goalsTeam2 ? team1 : goalsTeam1 < goalsTeam2 ? team2 : "Draw"));
    }
}

public class SportsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Hockey Match:");
        System.out.print("Team 1 Name: ");
        String hockeyTeam1 = scanner.nextLine();
        System.out.print("Team 2 Name: ");
        String hockeyTeam2 = scanner.nextLine();
        System.out.print("Goals for Team 1: ");
        int hockeyGoalsTeam1 = scanner.nextInt();
        System.out.print("Goals for Team 2: ");
        int hockeyGoalsTeam2 = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        Sports hockeyMatch = new Hockey(hockeyTeam1, hockeyTeam2, hockeyGoalsTeam1, hockeyGoalsTeam2);
        hockeyMatch.dispTeam();

        System.out.println();

        System.out.println("Enter details for Football Match:");
        System.out.print("Team 1 Name: ");
        String footballTeam1 = scanner.nextLine();
        System.out.print("Team 2 Name: ");
        String footballTeam2 = scanner.nextLine();
        System.out.print("Goals for Team 1: ");
        int footballGoalsTeam1 = scanner.nextInt();
        System.out.print("Goals for Team 2: ");
        int footballGoalsTeam2 = scanner.nextInt();

        Sports footballMatch = new Football(footballTeam1, footballTeam2, footballGoalsTeam1, footballGoalsTeam2);
        footballMatch.dispTeam();

        scanner.close();
    }
}
