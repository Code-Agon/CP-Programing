/**

A permutation p1,p2...pN of {1,2,...,N} is beautiful if pi&pi+1 is greater than 0 for every 1≤i<N . 
You are given an integer N, and your task is toconstruct a beautiful permutation of length N or 
determine that it's impossible

Sample Input:
3
4
3
5
Sample Output:
-1
1 3 2
2 3 1 5 4
**/

#include <iostream>
using namespace std;
int main()
{
   int t;cin>>t;
   while(t--){
       int n;
       cin>>n;
       if(n==1){
         cout<<"1\n"; 
         continue;
       } 
       if((n&(n-1))==0) cout<<"-1\n";
       else{
           
           if(n==3){
               cout<<"1 3 2\n";
           }else if(n==5){
               cout<<"2 3 1 5 4\n";
           }else{
                cout<<"2 3 1 5 4 ";
                for(int i=6;i<=n;i++){
                    if((i&(i-1))==0) cout<<i+1<<" ";
                    else if(((i-2)&(i-1))==0) cout<<i-1<<" ";
                    else cout<<i<<" ";
                }
                cout<<"\n";
           }
       }
   }
   return 0;
}
