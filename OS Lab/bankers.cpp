#include<iostream>
using namespace std;
int main()
{
	int a[10][10],b[10],available[10] , done [10];
	int allocate[10][10] , maxall[10][10] , needed[10][10];
	int p,r;
	cout<<"\n ENTER THE NUMBER OF PROCESSES AND NO. OF RESOURCES :";
	cin>>p>>r;
	cout<<"\nMAX RESOURCES AVAILABLE";
	for(int i=0; i<r; i++)
	{
		cin>>available[i];
	}
	
	cout<<"\nENTER THE ALLOCATION MATRIX \n";
	for(int i=0; i<p; i++)
	{
	
		done[i]=-1;
		for(int j=0; j<r; j++)
		{
			cin>>allocate[i][j];
		}
	}
	cout<<"\nENTER THE max MATRIX \n";
	for(int i=0; i<p; i++)
	{
		for(int j=0; j<r; j++)
		{
			cin>>maxall[i][j];
			needed[i][j] = maxall[i][j] - allocate[i][j];
		}
	}
	cout<<"\n PROCESS SEQUENCES :";
	int index=-1;
	for(int i=0; i<p; i++)
	{
		index=-1;
		int flag=1;
		
		for(int j=0; j<p; j++)
		{
				flag=1;			
				
			
				if(done[j]==-1)
				{
				
					for(int k=0; k<r; k++)
					{
						if( needed[j][k] > available[k])
							flag=-1;
					}
					
					if(flag==1)
					{
						index = j ;
						done [index] = 1;
						break;
					}
					
				}
		}
		
		if(flag==-1)
		{
			cout<<"\n DEADLOCK ";
			break;
		}else
		{
			cout<<"  P"<<index; 
		}
		for(int k=0; k<r; k++)
		{
			available[k] += allocate[index][k] ;
		}	
	}
	
	return 0;
}

