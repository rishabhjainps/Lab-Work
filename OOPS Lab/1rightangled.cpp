#include<iostream>
#include<math.h>
#include<conio.h>
using namespace std;
class righttriangle
{
      float height,base;
      public:
             void getvalue()
             {
                   cout<<"\nENTER THE HEIGHT OF THE TRIANGLE :";
 				   cin>>height;
  				  cout<<"\nENTER THE BASE OF THE TRIANGLE :"; 
   			    	cin>>base;
              }
           float perimeter();
          float area(); 
      };
float righttriangle::perimeter()
{
     float a= height+base+sqrt((height*height)+(base*base));
     return a;
 }

float righttriangle::area()
{
     float a= base*height/2;
     return a;
 }
int main()
{
   righttriangle one;
   one.getvalue();
   cout<<"\nPERIMETER OF TRIANGLE :"<<one.perimeter();
   cout<<"\n\nAREA OF TRIANGLE :"<<one.area();
   getch();
   return 0;
}
