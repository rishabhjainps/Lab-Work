#include<iostream>
#include<math.h>
#include<conio.h>
using namespace std;
class shape
{
      protected:
             int x;
             int y;
             int x1;
             int y1;   
      public :
             virtual void input()=0;
             virtual void calculate()=0;
};

class point :public shape
{
      public :
             void input()
             {
                  cout<<"\n\t\t POINT ";     
                  cout<<"\nENTER THE CO-ORDINATES OF POINT :";
                  cin>>x>>y;
              }
             void calculate()
             {
                   cout<<"\n\t\t POINT " ; 
                   cout<<"\nAREA : 0"; 
                   cout<<"\nPERIMETER : 0";                
             }  

};

class line :public shape
{
      public :
             void input()
             {
                  cout<<"\n\t\t LINE " ;    
                  cout<<"\nENTER THE TWO (x,y) CO-ORDINATES OF LINE :";
                  cin>>x>>y;
                  cout<<"\nENTER THE TWO (x1,y1) CO-ORDINATES OF LINE :";
                  cin>>x1>>y1;
              }
              void calculate()
             {
                   cout<<"\n\t\t LINE ";  
                   cout<<"\nAREA : 0"; 
                   float p = sqrt ( pow(x-x1,2)+pow(y-y1,2)); 
                   cout<<"\nPERIMETER : "<<p;                
             }  

};
class circle :public shape
{
      public :
             void input()
             {
                  cout<<"\n\t\t CIRCLE " ;    
                  cout<<"\nENTER THE CO-ORDINATES OF CENTER OF CIRCLE :";
                  cin>>x>>y;
                  cout<<"\nENTER THE CO-ORDINATES  OF ANY POINT ON CIRCUMFERENCE OF CIRCLE :";
                  cin>>x1>>y1;
              }
             void calculate()
             {
                   cout<<"\n\t\t CIRCLE "; 
                   float r = sqrt ( pow(x-x1,2)+pow(y-y1,2));  
                   cout<<"\nAREA :"<<3.14*r*r; 
                   cout<<"\nPERIMETER : "<<2*3.14*r;                
             }  

};

class rectangle :public shape
{
      public :
             void input()
             {
                  cout<<"\n\t\t RECTANGLE " ;    
                  cout<<"\nENTER THE CO-ORDINATES OF CORNER OF RECTANGLE :";
                  cin>>x>>y;
                  cout<<"\nENTER THE CO-ORDINATES OF DAIGONALLY OPPOSITE CORNER  :";
                  cin>>x1>>y1;
              }
             void calculate()
             {
                   cout<<"\n\t\t RECTANGLE  "; 
                   float area = (x-x1)*(y-y1);  
                   float perimeter =fabs( 2*(x-x1)+2*(y-y1) );  
                   cout<<"\nAREA :"<<area; 
                   cout<<"\nPERIMETER : "<<perimeter;                
             }  

};

class square :public shape
{
      public :
             void input()
             {
                  cout<<"\n\t\t SQUARE " ;    
                  cout<<"\nENTER THE CO-ORDINATES OF CORNER OF SQUARE :";
                  cin>>x>>y;
                  cout<<"\nENTER THE CO-ORDINATES OF DAIGONALLY OPPOSITE CORNER OF SQUARE :";
                  cin>>x1>>y1;
              }
             void calculate()
             {
                   cout<<"\n\t\t SQUARE  "; 
                   float area = (x-x1)*(y-y1);  
                   float perimeter = fabs( 2*(x-x1)+2*(y-y1) );  
                   cout<<"\nAREA :"<<area; 
                   cout<<"\nPERIMETER : "<<perimeter;                
             }  

};

int main()
{
  shape *s[5];
  point p;
  line l;
  circle c;
  rectangle r;
  square sq;

  s[0]=&p;
  s[1]=&l;
  s[2]=&c;
  s[3]=&r;
  s[4]=&sq;
 
 for(int i=0; i<5; i++)
 {
         s[i]->input();
         } 
         
  for(int i=0; i<5; i++)
 {
         s[i]->calculate();
         }  
    
    
 getch();   
 return 0;   
}
