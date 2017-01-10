#include<iostream>
#include<math.h>
#include<conio.h>
using namespace std;
class righttriangle
{
      float height,base;
      public:
             void getvalue(float a,float b)
             {
                  height=a;
                  base=b;
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
   float h,b;
   cout<<"\nENTER THE HEIGHT AND BASE:";
   cin>>h>>b;
   one.getvalue(h,b);
   
    cout<<"\nPerimeter:"<<one.perimeter();
     cout<<"\nAREA:"<<one.area();
    getch();
    return 0;
}
