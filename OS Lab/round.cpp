#include<iostream>
#include<algorithm>
#include<conio.h>
#include<queue>

using namespace std;

struct pos_id
{
	int id;
	int arrival_time;
	int burst_time;
	int rburst_time;
	int completion_time;
	int turn_around_time;
	int waiting_time;
	int response_time;
}p[100];


int comp(pos_id a,pos_id b)
{
	return a.arrival_time<b.arrival_time;
}

int comp1(pos_id a,pos_id b)
{
	return a.id<b.id;
}

int main()
{
	queue <int> q;
	
	int n, quantum, time_passed=0;
	int index;
	float avg_turn=0 , avg_wait=0 ;
	
	cout<<"\nENTER THE NO. OF ID AND QUANTUM  TO BE ENTER ";
	cin>>n>>quantum;
	cout<<"\nENTER THE ARRIVAL AND BURST TIME OF IDS \n";
	for(int i=0; i<n; i++)
	{
		cin>>p[i].arrival_time>>p[i].burst_time;
		p[i].rburst_time=p[i].burst_time;
		p[i].id=i+1;;
	}
	
	sort(p,p+n,comp);

	int counter=0;
	
	q.push(0);
	time_passed=p[0].arrival_time;
	counter++;
	cout<<"\n";
while(counter<n)
{	
	while(!q.empty())
	{
		
		int index=q.front();
		cout<<index<<" ";
		if(p[index].burst_time>quantum)
		{
			p[index].burst_time -= quantum ;
			time_passed += quantum ;
			while(counter<n && time_passed>=p[counter].arrival_time)
			{   q.push(counter);
				counter++;		}
			q.push( index );
			q.pop();
			
		}
		else
		{
			time_passed += p[index].burst_time ;
			p[index].completion_time=time_passed;
			q.pop();
		}
	}
 
    if(counter<n)
    {
                 time_passed = p[counter].arrival_time;
                 q.push(counter);
                 }
}
	for(int index=0; index<n; index++)
	{
	    p[index].turn_around_time = p[index].completion_time - p[index].arrival_time ; 
		p[index].waiting_time = p[index].turn_around_time - p[index].rburst_time;          
    }
	
	sort(p,p+n,comp1);
	cout<<"\n\n";
	cout<<"ID \t ARR. \t BUR. \t COMP. \t TURN. \t WAIT. ";
	for(int i=0; i<n; i++)
	{
		cout<<"\n"<<p[i].id<<"\t  "<<p[i].arrival_time<<"\t    "<<p[i].rburst_time<<"\t    "
				<<p[i].completion_time<<"\t    "<<p[i].turn_around_time<<"\t    "
				<<p[i].waiting_time;
		
		avg_turn += p[i].turn_around_time;
		avg_wait += p[i].waiting_time;
	
	}
	
	avg_turn /= n; 
	avg_wait /= n; 
	
	cout<<"\n\nAVERAGE TURN AROUND TIME : "<<avg_turn;
	cout<<"\n\nAVERAGE WAITING AROUND TIME : "<<avg_wait;
	getch();
	return 0;
}
