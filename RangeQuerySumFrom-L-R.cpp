#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int main() {
    int n,q;
    cin>>n>>q;
    long arr[n+1]={0};
    for(int i=1;i<n+1;i++){
        cin>>arr[i];
        arr[i]+=arr[i-1];
    }
    for(int j=0;j<q;j++){
        int l,r;
        cin>>l>>r;
        cout<<arr[r]-arr[l-1]<<"\n";
    }
}


