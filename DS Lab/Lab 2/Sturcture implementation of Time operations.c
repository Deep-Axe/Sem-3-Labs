#include <stdio.h>

typedef struct{
    int hour;
    int min;
    int sec;
}Time;

void readTimeInfo(Time t[]) {
    for (int i = 0; i < 2; i++) {
        printf("Enter time %d:\n", i + 1);
        printf("Hour: ");
        scanf("%d", &t[i].hour);
        printf("Minute: ");
        scanf("%d", &t[i].min);
        printf("Seconds: ");
        scanf("%d", &t[i].sec);
        printf("\n");
    }
}

void displayTimeInfo(Time t) {
    printf("HOUR: %d\n", t.hour);
    printf("MIN: %d\n", t.min);
    printf("SEC: %d\n", t.sec);
    printf("\n");
}

Time ADD(Time t1, Time t2){
    printf("Addition \n");
    Time result;

    result.sec = t1.sec + t2.sec;
    result.min = t1.min + t2.min + (result.sec / 60);
    result.hour = t1.hour + t2.hour + (result.min / 60);

    result.sec = result.sec % 60;
    result.min = result.min % 60;

    return result;

}

Time SUBTRACT(Time t1, Time t2) {
    printf("Difference \n");
    Time result;

    int totalSec1 = t1.hour * 3600 + t1.min * 60 + t1.sec;
    int totalSec2 = t2.hour * 3600 + t2.min * 60 + t2.sec;

    int totalSecResult = totalSec1 - totalSec2;

    if (totalSecResult < 0) {
        totalSecResult = -totalSecResult;
        result.hour = -(totalSecResult / 3600);
        result.min = -(totalSecResult % 3600) / 60;
        result.sec = -(totalSecResult % 3600) % 60;
    } else {
        result.hour = totalSecResult / 3600;
        result.min = (totalSecResult % 3600) / 60;
        result.sec = (totalSecResult % 3600) % 60;
    }
    return result;
}

int main() {
    Time times[2];
    Time sumTime;
    Time diffTime;
    readTimeInfo(times);
    sumTime = ADD(times[0], times[1]);
    displayTimeInfo(sumTime);

    diffTime = SUBTRACT(times[0], times[1]);
    displayTimeInfo(diffTime);

    return 0;
}
