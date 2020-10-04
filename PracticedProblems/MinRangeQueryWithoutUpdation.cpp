/**
Given an array of n integers, your task is to process q queries of the form: what is the minimum value in range [a,b]?

Input

The first input line has two integers n and q: the number of values and queries.

The second line has n integers x1,x2,…,xn: the array values.

Finally, there are q lines describing the queries. Each line has two integers a and b: what is the minimum value in range [a,b]?

Output

Print the result of each query.

Constraints
1≤n,q≤2⋅105
1≤xi≤109
1≤a≤b≤n
Example

Input:
8 4
3 2 4 5 1 1 5 3
2 4
5 6
1 8
3 3

Output:
2
1
1
4
**/

#include <iostream>
#include<bits/stdc++.h>
using namespace std;
int buildSegTree(int index,int low,int hig,int arr[],int seg[]){
    if(low==hig){
        seg[index] = arr[low];
        return seg[index];
    }
    int mid = low+(hig-low)/2;
    int left = buildSegTree(2*index+1,low,mid,arr,seg);
    int right = buildSegTree(2*index+2,mid+1,hig,arr,seg);
    seg[index] = min(left,right);
    return seg[index];
}
int MinQuery(int low,int hig,int index,int l,int r,int seg[]){
    if(l>hig || r<low) return INT_MAX;
    if(l<=low && r>=hig) return seg[index];
    int mid = (low+hig)/2;
    int left = MinQuery(low,mid,2*index+1,l,r,seg);
    int right = MinQuery(mid+1,hig,2*index+2,l,r,seg);
    return min(left,right);
    
}
int main()
{
   int n,q;
   cin>>n>>q;
   int arr[n],seg[4*n]={0};
   for(int i=0;i<n;i++){
       cin>>arr[i];
   }
    buildSegTree(0,0,n-1,arr,seg);
    for(int i=0;i<q;i++){
        int l,r;
        cin>>l>>r;
        int m = MinQuery(0,n-1,0,l-1,r-1,seg);
        cout<<m<<"\n";
    
    }
   return 0;
}
