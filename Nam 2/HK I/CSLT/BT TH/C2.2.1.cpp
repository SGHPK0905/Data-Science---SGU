#include <iostream>
using namespace std;
int main()
{
  system("cls");  
  char baitap;
  switch (baitap)
  {
    case 'a' :
     {
      int n,tong=0; 
      cout<<"Nhap n: "; cin>>n;
      for (int i=1; i<n; i++)
      { if (n%i==0) tong += i; }
      if (n==tong)
      cout<<"n la so hoan thien"<<endl;
      else
      cout<<"n khong la so hoan thien"<<endl;
     } 
    break;
  default :
   cout<<"Vui long chon lai bai tap"<<endl;
  }
  
  
system("pause");
return 0;
}