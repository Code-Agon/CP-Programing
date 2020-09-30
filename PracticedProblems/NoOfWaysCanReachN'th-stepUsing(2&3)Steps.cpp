#include<iostream>
#include<bits/stdc++.h>
#include<climits>
using namespace std;

int main() {
    int num = 1000001;
    long long int arr[num];
    arr[1]=0;
    arr[2]=1;
    arr[3]=1;
    for(int k=4;k<num;k++){
        arr[k] = (arr[k-2]+arr[k-3])%1000000009;
    }
	int t;
	cin>>t;

	while(t--) {
		int n;
		cin>>n;
		
		cout<<arr[n]<<"\n";

	}
	return 0;
}
