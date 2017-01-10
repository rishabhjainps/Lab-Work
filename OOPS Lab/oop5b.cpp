#include<iostream>
#include<conio.h>
using namespace std;
class registers
{
char dept[40];
int year;
int semester;
public:int rollno;
       registers()
{rollno=0;
strcpy(dept,"");
year=0;
semester=0;
}
void registration(int roll,char *dep,int yr,int sem)
{rollno=roll;
strcpy(dept,dep);
year=yr;
semester=sem;}
void display()
{cout<<"roll no:"<<rollno;
cout<<"department:"<<dept;
cout<<"year:"<<year;
cout<<"sem:"<<semester;
}
 void changedept(char *dep)
 {strcpy(dept,dep);
 }};
int main()
 {registers r[50];int n,re,roll,yr,sem;char dep[40];
 cout<<"enter the no. of students whose data you wnt to enter\n";
 cin>>n;
 for(int i=0;i<n;i++)
 {
 cout<<"enter roll no.\n";
 cin>>roll;
 cout<<"enter the dept.\n";
 cin>>dep;
 cout<<"enter the yr.\n";
 cin>>yr;
 cout<<"enter semester:\n";
 cin>>sem;
 registers();
 r[i].registration(roll,dep,yr,sem);}
 int j;
 cout<<"please enter 1 for change of dept and 0 for continue";
 cin>>j;
 if(j==1)
 {cout<<"enter the roll no";
 cin>>re;
  for(int i=0;i<n;i++)
  {if(re==r[i].rollno)
        { char de[40];
 cout<<"enter department ";
 cin>>de;
 r[i].changedept(de);
 cout<<"you have successfully changed your dept";
 r[i].display();}
 else
 {cout<<"you entered wrong roll no.";}}}
 
 
 
 getch();
 return 0;}
 
