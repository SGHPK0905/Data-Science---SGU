#include <iostream>
#include <cmath>
#define PI 3.14
using namespace std;

int main() {
   double xa,ya,xb,yb,xc,yc;
   cout<<"Nhap xa: ";cin>>xa;
   cout<<"Nhap ya: ";cin>>ya;
   cout<<"Nhap xb: ";cin>>xb;
   cout<<"Nhap yb: ";cin>>yb;
   cout<<"Nhap xc: ";cin>>xc;
   cout<<"Nhap yc: ";cin>>yc;

double Gx=(xa+xb+xc)/3;
double Gy=(ya+yb+yc)/3;
double a = sqrt(pow(xb-xc, 2)+pow(yb-yc, 2));
double b = sqrt(pow(xa-xc, 2)+pow(ya-yc, 2));
double c = sqrt(pow(xa-xb, 2)+pow(ya-yb, 2));
double p = (a+b+c)/2;
double s = sqrt(p*(p-a)*(p-b)*(p-c));
double r = s/p;
double nt = PI*pow(r, 2);
double R = (a*b*c)/(4*5);
double ngt = PI*pow(R, 2);

   cout<<"Toa do trong tam: Gx =" <<Gx<<", Gy = "<<Gy<<endl;
   cout<<"Dien tich duong tron noi tiep = "<<nt<<endl;
   cout<<"Dien tich duong trong ngoai tiep ="<<ngt<<endl;
    
    system ("pause");
    return 0;
}
