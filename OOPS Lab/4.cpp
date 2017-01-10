#include<iostream>
#include<math.h>
#include<conio.h>
using namespace std;
class income{
      float basic,da,hra;
      float salary;
      public:
      float paysalry(float a,float b,float c)
      {
            basic=a;
            da=b;
            hra=c;
            salary=basic+da+(hra*0.15);
            return salary;
            }
            
      float deduction()
      {
            return 0.08*basic;
            }
      float tax()
      {
            float tax;
            if(salary<100000)
            {	tax=salary*0.2;	}
            else
            if(salary>=100000)
            {
            	tax=0.3*salary;
            	tax=1.1*tax;
         	 }
            return tax;
            }      
 };
      
      
int main()
{

   income a;
   float basic,hra,da;
   cout<<"\n ENTER THE BASIC,HRA ,DA :";
   cin>>basic>>hra>>da; 
   cout<<"\n SALARY :"<<  a.paysalry(basic,hra,da);
   cout<<"\n Deduction :"<<  a.deduction();
   cout<<"\n TAXES :"<<  a.tax();  
   return 0;
}
