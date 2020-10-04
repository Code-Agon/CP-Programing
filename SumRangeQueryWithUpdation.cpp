/**
Given an array of n integers, your task is to process q queries of the following types:
update the value at position k to u
what is the sum of values in range [a,b]?
Input

The first input line has two integers n and q: the number of values and queries.

The second line has n integers x1,x2,…,xn: the array values.

Finally, there are q lines describing the queries. Each line has three integers: either "1 k u" or "2 a b".

Output

Print the result of each query of type 2.

Constraints
1≤n,q≤2⋅105
1≤xi,u≤109
1≤k≤n
1≤a≤b≤n
Example

Input:
8 4
3 2 4 5 1 1 5 3
2 1 4
2 5 6
1 3 1
2 1 4

Output:
14
2
11
**/
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long int ll;
ll buildSegTree(int index,int low,int hig,ll arr[],ll seg[]){
    if(low==hig){
        seg[index] = arr[low];
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
   int n,q;
   cin>>n>>q;
   ll arr[n];
   ll seg[4*n]={0};
   for(int i=0;i<n;i++){
       cin>>arr[i];
   }
    buildSegTree(0,0,n-1,arr,seg);
    for(int i=0;i<q;i++){
        int k;
        cin>>k;;
        if(k==2){
            int l,r;
            cin>>l>>r;
        ll m = SumQuery(0,n-1,0,l-1,r-1,seg);
        cout<<m<<"\n";
        }
        else{
            int l;
            ll r;
            cin>>l>>r;
            ll diff = r-arr[l-1];
            arr[l-1]=r;
            updateSegTree(0,n-1,0,l-1,diff,seg);
         }
        
    
    }
   return 0;
}
