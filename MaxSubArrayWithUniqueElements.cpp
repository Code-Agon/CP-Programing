
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
    long n;
    cin>>n;
    long arr[n+1],count=0,ma=0,con=0;
    map<long,int> m;
    for(int i=1;i<n+1;i++){
        cin>>arr[i];
    }
    for(int i=1;i<n+1;i++){
        if(m[arr[i]]==0){
            m[arr[i]]=i;
            count++;
        }else{
            if(m[arr[i]]>con){
               con = m[arr[i]];
               count=i-m[arr[i]];
               
            }else{
                count++;
            }
            m[arr[i]]=i;
        }
       ma=max(ma,count);
    }
    cout<<ma;

    return 0;
}
