#include<bits/stdc++.h>
using namespace std;
// 5^n
typedef long long ll;
#define MOD 1000000007

int n,a[10000][1000],minimum,maximum;
int main() {
    cout<<"Enter the number of input variables (max.100) & [ minimum , maximum ] value  :";
    cin>>n;
    cin>>minimum>>maximum;
    int counter=-1;
    int values[]={minimum-1,minimum,minimum+1,(minimum + maximum )/2,maximum-1,maximum,maximum+1};
    int m = sizeof(values)/sizeof(values[0]);
    int range = pow(7,n);
    for(int i=0; i<range; i++){
        int k=i;
        for(int j=0; j<n; j++){
            a[i][j] = values[k%m];
            k=k/m;
        }
    }
    cout<"\n\n";
    cout<<setw(8)<<"TEST ID";
    for(int j=0 ; j<n; j++){
            cout<<setw(8)<<j+1;
    }
    cout<<"\n\n";
    // 5^n : Worst case Values
     for(int i=0 ; i<range; i++){
            cout<<setw(8)<<i+1;
            for(int j=0 ; j<n; j++){
               cout<<setw(8)<<a[i][j];
            }
            cout<<"\n";
      }
	return 0;
}
