#include <stdio.h>
#include <string.h>
#define MAX 50

typedef struct{
    char name[MAX];
    int roll;
    char gr;
}Student;
void readStudentInfo(Student students[], int count) {
    for (int i = 0; i < count; i++) {
        printf("Enter Student %d details\n", i + 1);
        printf("Name: ");
        scanf(" %[^\n]s", students[i].name);
        printf("Roll: ");
        scanf("%d", &students[i].roll);
        printf("Grade: ");
        scanf(" %c", &students[i].gr);
        printf("\n");
    }
}
void displayStudentInfo(Student students[], int count) {
    printf("Student Info:\n");
    for (int i = 0; i < count; i++) {
        printf("Name: %s\n", students[i].name);
        printf("Roll: %d\n", students[i].roll);
        printf("Grade: %c\n", students[i].gr);
        printf("\n");
    }
}
void sortStudentsByRollNo(Student students[], int count) {
    Student temp;
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            if (students[i].roll > students[j].roll) {
                temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
    }
}
int main() {
    int n;
    printf("Enter the number of students: ");
    scanf("%d", &n);
    Student students[n];
    readStudentInfo(students, n);
    sortStudentsByRollNo(students, n);
    displayStudentInfo(students, n);
    return 0;
}
