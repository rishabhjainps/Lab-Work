#include<iostream>
#include<conio.h>
using namespace std;
class employee{
	  int number;
	  char c[15];
	  int rank;
	  float salary;
	  public:
	  		employee()
	  		{
			 		  number=0;
			 		  c[0]='\0';
			 		  rank=0;
			 		  salary=0.0;
					  }
			  void getdata()
			  {
			   	   cout<<"\nENTER THE NUMBER OF EMPLOYEE :";
			   	   cin>>number;
			   	   cout<<"ENTER THE date of birth OF EMPLOYEE :";
			   	   cin>>c;
			   	   cout<<"ENTER THE RANK OF EMPLOYEE :";
			   	   cin>>rank;
			   	   cout<<"ENTER THE Salary OF EMPLOYEE :";
			   	   cin>>salary;
				   }
			int getno()
			{
			return number;
				   }	   
		   void raise()
		   
		   {
		   		salary=1.1*salary;
		   	}
		   	void increaserank()
		   	{
			 	 rank=rank+1;
			 	 salary=1.25*salary;
			 }
			 
			 void display()
			 {
			  	 cout<<"\nNUMBER OF EMPLOYEE :"<<number;
			   	   cout<<"\ndate of birth OF EMPLOYEE :"<<c;
			   	   cout<<"\nRANK OF EMPLOYEE :"<<rank;
			   	   cout<<"\nSalary OF EMPLOYEE :"<<salary;  
			  	  
				  }
			 
			 
			 
	  };



int main()
{
 	employee e[10];
 	int n,t;
 	cout<<"\nENTER THE NO. OF EMPLOYEE YOU WANT TO ENTER :";
 	cin>>n;
 	cout<<"\nENTER EMPLOYEE DETAILS \n";
 	for(int i=0; i<n;i++)
 	{
 			cout<<"\n EMPLOYEES :"<<i+1;
	 		e[i].getdata();
	 }
 
 	cout<<"\nENTER THE EMPLOYEE NUMBER YOU WANT RAISE SALARY :";
 	cin>>t;
	for(int i=0; i<n; i++)
	{
		if(e[i].getno()==t)
		{
			e[i].raise();
		}
	}
 	cout<<"\nENTER THE EMPLOYEE NUMBER YOU WANT RAISE RANK :";
 	cin>>t;
	for(int i=0; i<n; i++)
	{
		if(e[i].getno()==t)
		{
			e[i].increaserank();
		}
	}
  	cout<<"\n\nEMPLOYEES DETAILS\n";
 	for(int i=0; i<n;i++)
 	{
 		cout<<"\n EMPLOYEES :"<<i+1;
		e[i].display();
	 }
 return 0;	
}
