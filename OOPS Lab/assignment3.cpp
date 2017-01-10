#include<iostream>
using namespace std;
class complex
{
	int x;
	int y;
public:
	complex()
	{
	
	}
	complex(int a ,int b=2)
	{
		x=a;
		y=b;
	}
	void operator --()
	{
		x--;
		y--;	
	}

	int operator &&(complex a)
	{
		if(x==0&&a.x==0)
			return 0;
		else
			return 1;
		
	}
	
	void display()
	{
	cout<<"\n"<<x<<"  "<<y;
	}
	
	friend complex operator -(complex a,complex b);
	
};


complex operator -(complex b,complex a)
{
    	complex temp ;
		temp.x=b.x-a.x;
		temp.y=b.y-a.y;
		return temp;

}
int main()
{
complex a(0,20),b(0,4),c(0,0);
if(a&&b)
cout<<"no zero";
return 0;	
}
