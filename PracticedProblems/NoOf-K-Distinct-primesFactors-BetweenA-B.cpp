#include <iostream>
#include<bits/stdc++.h>
using namespace std;
int main()
{
   int arr[100001]={0};
  
   for(int i=2;i<(int)100001/2;i++){
       if(arr[i]==0){
           for(int j=i;j<100001;j=j+i){
               arr[j]++;
           }
       }
   }
   vector<int> v[6];
   for(int i=2;i<100001;i++){
       if(arr[i]==0) arr[i]++;
       if(arr[i]<=5)
       v[arr[i]].push_back(i);
   }
    int t;
    cin>>t;
    while(t--){
        int a,b,k;
         cin >> a>> b >> k;
	    vector<int> :: iterator it1;
	    it1 = lower_bound(v[k].begin(),v[k].end(),a);

	        if(it1 == v[k].end())
	        {
	            cout << "0" <<"\n";
	            continue;
	        }
	        cout << upper_bound(v[k].begin(),v[k].end(),b)-it1 <<"\n";
    }
    
   
   return 0;
}
