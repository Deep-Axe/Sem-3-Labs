import java.util.Scanner;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void display() {
        System.out.printf("%02d:%02d:%02d%n", this.hours, this.minutes, this.seconds);
    }

    public static Time addTimes(Time t1, Time t2) {
        int totalSeconds = (t1.hours * 3600 + t1.minutes * 60 + t1.seconds) +
                           (t2.hours * 3600 + t2.minutes * 60 + t2.seconds);

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        if (hours >= 24) {
            hours = hours % 24;
        }

        return new Time(hours, minutes, seconds);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfTimes = 2;
        
        Time[] times = new Time[numberOfTimes];

        for (int i = 0; i < numberOfTimes; i++) {
            System.out.println("Enter hours for time: " + i + 1);
            int hours = sc.nextInt();
            System.out.println("Enter minutes for time "+ i + 1);
            int minutes = sc.nextInt();
            System.out.println("Enter seconds for time "+ i + 1);
            int seconds = sc.nextInt();

            times[i] = new Time(hours, minutes, seconds);
        }

        System.out.println("Entered times:");
        for (Time time : times) {
            time.display();
        }
        Time resultTime = addTimes(times[0], times[1]);
        System.out.printf("Sum of the first two times: " );
        resultTime.display();

        sc.close();
    }
}
