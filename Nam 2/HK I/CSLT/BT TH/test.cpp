#include <iostream>
#include <cmath>
#include <string.h>
using namespace std;

int main()
{
    char *gets(char* str); 
    char *tbp(char*s){
        return strchr(s,' ')+1;
    }

    char* tbtrai(char*s){
        return strrev(strchr(strrev(s),' ')+1);
    }
}
void tinhps()