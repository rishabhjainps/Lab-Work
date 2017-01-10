#include<iostream>
#include<math.h>
#include<conio.h>
using namespace std;
class complex
{	  
float real,img;     
  public:
     void insert(float a,float b)
     {
       real=a;
       img=b;
     }            
    void display()
    {
      cout<<real<<" +i "<<img;
	}		  
	complex Add(complex);
    complex Subtract(complex);
};      
complex complex::Add(complex a)
{
    complex c;
    c.real=a.real+real;
    c.img=a.img+img;
    return c;
}                 
complex complex::Subtract(complex b)
{
    complex c;
    c.real=real-b.real;
    c.img=img-b.img;
    return c;
}      
int main()
{
   complex one,two,fin;
   float r,i;
   cout<<"\nENTER THE TWO NUMBERS OF FIRST COMPLEX NUMBER:";
   cin>>r>>i;
   one.insert(r,i);
   cout<<"\nENTER THE TWO NUMBERS OF SECOND COMPLEX NUMBER:";
   cin>>r>>i;
   two.insert(r,i);
   fin=one.Add(two);
   cout<<"\nADDITION COMPLEX A AND B:";
   fin.display();
   fin=one.Subtract(two);
   cout<<"\nSUBTRACTION COMPLEX A AND B:";
   fin.display();
   getch();
   return 0;
}
