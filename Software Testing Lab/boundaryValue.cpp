#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
#define MOD 1000000007

int n,a[10000][1000],minimum,maximum;
int main() {
    cout<<"Enter the number of input variables (max.100) & [ minimum , maximum ] value  :";
    cin>>n;
    cin>>minimum>>maximum;
    int counter=-1;
    int values[]={minimum,minimum+1,maximum-1,maximum};
    int m = sizeof(values)/sizeof(values[0]);
    int optimal = (minimum + maximum )/2;
    for(int i=0 ; i<n; i++){
        for(int v=0; v<m; v++){
            counter++;
            for(int j=0 ; j<n; j++){
                if(i==j)
                    a[counter][j]=values[v];
                else
                    a[counter][j]=optimal;
            }
        }
    }
    counter++;
    for(int j=0 ; j<n; j++){
        a[counter][j]=optimal;
    }
    cout<<setw(8)<<"TEST ID";
    for(int j=0 ; j<n; j++){
            cout<<setw(8)<<j+1;
    }
    cout<<"\n\n";
    // 4n+1 : Boundary Values
     for(int i=0 ; i<4*n+1; i++){
            cout<<setw(8)<<i+1;
            for(int j=0 ; j<n; j++){
               cout<<setw(8)<<a[i][j];
            }
            cout<<"\n";
      }
	return 0;
}
