#include <iostream>
using namespace std;
int main(){
int a, b, c;
 cout<<"nhap a ="; cin>>a;
 cout<<"nhap b ="; cin>>b;
 cout<<"nhap c ="; cin>>c;

 // sap xep thu tu tang dan
 cout<<"\n Thu tu tang dan: ";
 if(a>=b&&b>=c){cout<<c<<" "<<b<<" "<<a;} else 
    {if(a>=c&&c>=b){cout<<b<<" "<<c<<" "<<a;} else
      {if(b>=a&&a>=c){cout<<c<<" "<<a<<" "<<b;} else 
        {if(b>=c&&c>=a){cout<<a<<" "<<c<<" "<<b;} else 
          {if(c>=a&&a>=b){cout<<b<<" "<<a<<" "<<c;} else 
            {if(c>=b&&b>=a){cout<<a<<" "<<b<<" "<<c;}}}}}}
 
 return 0;
 system("pause");
}

// Khởi tạo biến
// constructer
// loop (do-while, to-do, base for, for-each, while, recursion (đệ quy))
// cursor -> Array, param
// condition (if-else, switch-case-default, do-while, while)
// Define a function (void (khong tra ve gi car), Data Types(tra ve bien voi dung kieu du lieu))
// Array (Data_Types[] Array_name = {elements dung voi Data_Types} -> khoi tao mang cu the, co dinh; int[] Array_name = new int[MAX ||so luong phan tu co the chua|| param])
// Co bao nhieu Primitive_Data_Types: int, char, float, string, double, long, bool.
// operator: +, -, *, /, math.sqrt(), math.sqr(), math.pow, %
// int num = 5; char name = "5" if (num == name) || if (num === name);