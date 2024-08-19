#include <stdio.h>
#include <string.h>

#define MAX 100

int prec(char ch) {
    if (ch == '^')
        return 3;
    else if (ch == '/' || ch == '*')
        return 2;
    else if (ch == '+' || ch == '-')
        return 1;
    else
        return -1;
}

int main()
{
    char exp[MAX];
    int i;
    char result[1000];
    int res_Index = 0;
    char stack[1000];
    int stack_Index = -1;

    printf("Enter expression: ");
    gets(exp);

    int len = strlen(exp);

    for(i=0 ; i < len ; i++){
        char ch = exp[i];

        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= 0 && ch <=9)){
            result[res_Index++] = ch;
        }
        else if (ch == '('){
            stack[++stack_Index] = ch;
        }
        else if (ch == ')') {
            while (stack_Index >= 0 && stack[stack_Index] != '(') {
                result[res_Index++] = stack[stack_Index--];
            }
            stack_Index--;
        }
        else {
            while (stack_Index >= 0 && (prec(exp[i]) < prec(stack[stack_Index]) || prec(exp[i]) == prec(stack[stack_Index])))
            {
                result[res_Index++] = stack[stack_Index--];
            }
            stack[++stack_Index] = ch;
        }
    }
     while (stack_Index >= 0) {
        result[res_Index++] = stack[stack_Index--];
    }
    result[res_Index] = '\0';
    printf("%s\n", result);

    return 0;
}
