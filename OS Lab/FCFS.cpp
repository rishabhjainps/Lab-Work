#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;

struct pos_id
{
	int id;
	int arrival_time;
	int burst_time;
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
	
	int n, time_passed=0;
	int index;
	float avg_turn=0 , avg_wait=0 ;
	
	cout<<"\nENTER THE NO. OF ID TO BE ENTER ";
	cin>>n;
	cout<<"\nENTER THE ARRIVAL AND BURST TIME OF IDS \n";
	for(int i=0; i<n; i++)
	{
		cin>>p[i].arrival_time>>p[i].burst_time;
		p[i].id=i+1;;
	}
	
	sort(p,p+n,comp);
	
	
	
	for(int i=0; i<n; i++)
	{
		q.push(i);
	}
	
	
	
	while(!q.empty())
	{
	
		index=q.front();
		q.pop();
		
			if(time_passed<p[index].arrival_time)
				time_passed = p[index].arrival_time;
				
		p[index].response_time = time_passed - p[index ].arrival_time;
		
		time_passed += p[ index ].burst_time;
		p[index].completion_time = time_passed;
		
		p[index].turn_around_time = p[index].completion_time - p[index].arrival_time ; 
		p[index].waiting_time = p[index].turn_around_time - p[index].burst_time; 
	
	}
	
	
	sort(p,p+n,comp1);
	cout<<"\n\n";
	cout<<"ID \t ARR. \t BUR. \t COMP. \t TURN. \t WAIT. \t RESP.";
	for(int i=0; i<n; i++)
	{
		cout<<"\n"<<p[i].id<<"\t  "<<p[i].arrival_time<<"\t    "<<p[i].burst_time<<"\t    "
				<<p[i].completion_time<<"\t    "<<p[i].turn_around_time<<"\t    "
				<<p[i].waiting_time<<"\t    "<<p[i].response_time;
		
		avg_turn += p[i].turn_around_time;
		avg_wait += p[i].waiting_time;
	
	}
	
	avg_turn /= n; 
	avg_wait /= n; 
	
	cout<<"\n\nAVERAGE TURN AROUND TIME : "<<avg_turn;
	cout<<"\n\nAVERAGE WAITING AROUND TIME : "<<avg_wait;
	
	return 0;
}
