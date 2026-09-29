#include <iostream>
#include <cmath>
using namespace std;

int main(){
    float a, b, c;
    cout<<"Nhap a: "; cin>>a;
    cout<<"Nhap b: "; cin>>b;    
    cout<<"Nhap c: "; cin>>c;
    if(a==0)
    {
        cout<<"Phuong trinh tro thanh pt bac nhat !!";
        cout<<"\nPT co nghiem la: "<<-c/b;
    }
    else
    {
        float delta;
        delta=b*b-4*a*c;
        if(delta<0)
            cout<<"PT vo nghiem !!!";
        if(delta==0)
            cout<<"PT co nghiem kep: "<<-b/2*a;
        if(delta>0)
        {
            cout<<"\nPT co 2 nghiem phan biet !!!";
            cout<<"\nx1= "<<(-b+sqrt(delta))/2*a;
            cout<<"\nx2= "<<(-b-sqrt(delta))/2*a;          
        }
        cout<<endl; 
    }


    system("pause");
}