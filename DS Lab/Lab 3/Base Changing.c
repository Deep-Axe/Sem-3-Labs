#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int stack[MAX];
int top = -1;

void push(int a)
{
    if (top >= MAX -1){
        printf("OVERFLOW\n");
        exit(0);
    }
    stack[++top]  =  a;
}

int pop()
{
    if (top < 0){
        printf("UNDERFLOW\n");
        exit(0);
    }
    return stack[top--];
}
void convertDecimalToAnyBase(int num, int base){

    char dig[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int rem,val;
    if (num == 0){
        printf("0\n");
        return;
    }
    while(num > 0){
        rem = num % base;
        push(rem);
        num /= base;
    }
    while (top != -1){
        val = pop();
        printf("%c",dig[val]);
    }
}
int main(){
    int num, base;
    printf("Enter decimal number to change base: ");
    scanf("%d", &num);
    printf("Enter new base to be converted to: ");
    scanf("%d", &base);
    if (base < 2 || base > 36){
        printf("Invalid Base");
        exit(0);
    }
    convertDecimalToAnyBase(num, base);
    return 0;
}
