/**
Ashu and Shanu are best buddies. One day Shanu gives Ashu a problem to test his intelligence.
He gives him an array of N natural numbers and asks him to solve the following queries:-

Query 0:- modify the element present at index i to x.
Query 1:- count the number of even numbers in range l to r inclusive.
Query 2:- count the number of odd numbers in range l to r inclusive.

input:
First line of the input contains the number N. Next line contains N natural numbers.
Next line contains an integer Q followed by Q queries.
0 x y - modify the number at index x to y.
1 x y - count the number of even numbers in range l to r inclusive.
2 x y - count the number of odd numbers in range l to r inclusive.

Constraints:
1<=N,Q<=10^5
1<=l<=r<=N
0<=Ai<=10^9
1<=x<=N
0<=y<=10^9

Note:- indexing starts from 1.

SAMPLE INPUT 
6
1 2 3 4 5 6
4
1 2 5
2 1 4
0 5 4
1 1 6
SAMPLE OUTPUT 
2
2
4
**/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long int ll;
ll buildSegTree(int index,int low,int hig,ll arr[],ll seg[]){
    if(low==hig){
        if(arr[low]%2==0)
        seg[index] = 1;
        return seg[index];
    }
    int mid = low+(hig-low)/2;
    ll left = buildSegTree(2*index+1,low,mid,arr,seg);
    ll right = buildSegTree(2*index+2,mid+1,hig,arr,seg);
    seg[index] = left+right;
    return seg[index];
}
ll SumQuery(int low,int hig,int index,int l,int r,ll seg[]){
    if(l>hig || r<low) return 0;
    if(l<=low && r>=hig) return seg[index];
    int mid = (low+hig)/2;
    ll left = SumQuery(low,mid,2*index+1,l,r,seg);
    ll right = SumQuery(mid+1,hig,2*index+2,l,r,seg);
    return left+right;
    
}
void updateSegTree(int low,int hig,int index,int i,ll diff,ll seg[]){
    if(i<low || i>hig ) return;
    seg[index]+=diff;
    int mid = low+(hig-low)/2;
    if(low!=hig){
    updateSegTree(low,mid,2*index+1,i,diff,seg);
    updateSegTree(mid+1,hig,2*index+2,i,diff,seg);
    }

}
int main()
{
   int n;
   cin>>n;
   ll arr[n];
   ll seg[4*n]={0};
   for(int i=0;i<n;i++){
       cin>>arr[i];
   }
   int q;
   cin>>q;
    buildSegTree(0,0,n-1,arr,seg);
    for(int i=0;i<q;i++){
        int k;
        cin>>k;;
        if(k==2 || k==1){
            int l,r;
            cin>>l>>r;
            ll m = SumQuery(0,n-1,0,l-1,r-1,seg);
            if(k==1){
                cout<<m<<"\n";
            }else{
             cout<<(r-l+1)-m<<"\n";   
            }
            
        }
        else{
            int l;
            ll r;
            cin>>l>>r;
            if(arr[l-1]%2!=r%2){
                if(r%2==0){
                    updateSegTree(0,n-1,0,l-1,1,seg);
                }else{
                    updateSegTree(0,n-1,0,l-1,-1,seg);
                }
                arr[l-1]=r;
            }
            
         }
    }
   return 0;
}
