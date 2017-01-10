#include<iostream>
#include<conio.h>
#include<algorithm>
#include<queue>
using namespace std;

struct pos_id
{
	int id;
	int done;
	int arrival_time;
	int burst_time;
	int burst_copy;
	int priority;
	int completion_time;
	int turn_around_time;
	int waiting_time;
	int response_time;
}p[100];

int main()
{

	int n;
	int index=-1;
	float avg_turn=0 , avg_wait=0 ;
	
	cout<<"\nENTER THE NO. OF ID TO BE ENTER ";
	cin>>n;
	cout<<"\nENTER THE ARRIVAL , BURST TIME , PRIORITY OF IDS \n";
	for(int i=0; i<n; i++)
	{
		cin>>p[i].arrival_time>>p[i].burst_time>>p[i].priority;
		p[i].done=-1;
		p[i].burst_copy=p[i].burst_time;
		p[i].id = i ;
	}
	
	cout<<"\nGANTT CHART : ";
	
	int time_passed=0;
	
	for(int j=0; j<n; j++)
    {	
           index=-1;
           while(index==-1)
           {
            	for(int i=0; i<n; i++)
            	{
                    
                    if(time_passed>=p[i].arrival_time&&p[i].done==-1)
                    {
                            if(index==-1)
                            {
                                index=i;
                                
                             }else
                             {
                                  if(p[index].priority>p[i].priority)
                                  {
                                     index=i;
                                  }
                              }  
                    }
                }
                cout<<index+1<<"  ";
                
				  if(index==-1)
                  {time_passed++;}
           }
           
                time_passed += p[index].burst_time;
                p[index].completion_time=time_passed;
				  
                p[index].done=1;  
                 
               	p[index].turn_around_time = p[index].completion_time - p[index].arrival_time ; 
    		    p[index].waiting_time = p[index].turn_around_time - p[index].burst_time;  
    }
            
        
	cout<<"\n\n";
	cout<<"ID \t ARR. \t BUR. \t COMP. \t TURN. \t WAIT. ";
	for(int i=0; i<n; i++)
	{
		cout<<"\n"<<p[i].id<<"\t  "<<p[i].arrival_time<<"\t    "<<p[i].burst_copy<<"\t    "
				<<p[i].completion_time<<"\t    "<<p[i].turn_around_time<<"\t    "
				<<p[i].waiting_time<<"\t    ";
		
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
