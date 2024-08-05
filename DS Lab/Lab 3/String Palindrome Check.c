#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100

int top = -1, front = 0;
int stack[MAX];

void push(char a)
{
    top++;
    stack[top]  =  a;
}

void pop()
{
    top--;
}

int main()
{
    int i, choice;
    char s[MAX], b;
	printf("Enter the String: ");
	gets(s);
	for (i = 0;s[i] != '\0';i++)
	{
		b = s[i];
		push(b);
	}
	for (i = 0;i < (strlen(s) / 2);i++)
	{
		if (stack[top] == stack[front])
		{
			pop();
			front++;
		}
		else
		{
			printf("%s is not a palindrome\n", s);
			break;
		}
	}
	if ((strlen(s) / 2)  ==  front)
		printf("%s is a palindrome\n",  s);
	front  =  0;
	top  =  -1;
	return 0;
}
