
/**A subarray A[i, j], where 1 ≤ i ≤ j ≤ N is a sequence of integers Ai, Ai+1, ..., Aj.

A subarray A[i, j] is non-decreasing if Ai ≤ Ai+1 ≤ Ai+2 ≤ ... ≤ Aj. You have to count the total number of such subarrays. **/
#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main() {
	int t;
	cin>>t;

	while(t--) {
		int n;
		cin>>n;
		int arr[n+1]={0};
		for(int i=0;i<n;i++) cin>>arr[i];
		long long int count=1;
		long long int sum=0;
		for(int i=0;i<n+1;i++){
		    if(arr[i]<=arr[i+1]){
		        count++;
		    }else{
		        sum+=(count*(count+1))/2;
		        count=1;
		       
		    }
		}
		cout<<sum<<"\n";

	}
	return 0;
}
