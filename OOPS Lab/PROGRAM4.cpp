#include<iostream>
#include<string.h>
using namespace std;
class registers{
	int rollno;
	char department[100];
	int semester;
	int year;
	public:
	registers()
	{
		rollno=0;
		strcpy(department," ");
		year=0;
		semester=0;
	}
	void registration(int roll,char *dep,int yr,int sem)
	{
		rollno=roll;
		strcpy(department,dep);
		year=yr;
		semester=sem;
	}
	void display()
	{

		cout<<"\n ROLL NO :"<<rollno;
		cout<<"\n DEPARTMENT :"<<department;
		cout<<"\n YEAR :"<<year;
		cout<<"\n SEMESTER :"<<semester;


	}
	void changedepartment(char *dep)
	{
		strcpy(department,dep);
	}

	int getrollno()
	{
		return rollno;
	}
}s[50];


int main()
{
	int rollno;
	char department[100];
	int semester,n;
	int year;
cout<<"\nHOW MANY STUDENT INFO YOU WANT TO ENTER ";
cin>>n;
for(int i=0; i<n; i++)
{
    	cout<<"\n\n STUDENT :"<<i+1<<"\n";
		cout<<"\n ROLL NO :";
		cin>>rollno;
		cout<<" DEPARTMENT :";
		cin>>department;
		cout<<" YEAR :";
		cin>>year;
		cout<<" SEMESTER :";
		cin>>semester;
		s[i].registration(rollno,department,year,semester);
}
cout<<"\n\n ENTER THR STUDENT ROLLNO YOU WANT TO CHANGE AND DEPARTMENT NAME:";
cin>>rollno;
cin>>department;
for(int i=0; i<n; i++)
{
	if(s[i].getrollno()==rollno)
	{
		s[i].changedepartment(department);
	}
}
cout<<"\n STUDENT INFO \n\n ";
for(int i=0; i<n; i++)
{
		cout<<"\n\n STUDENT :"<<i+1<<"\n";
		s[i].display();
}

return 0;
}

