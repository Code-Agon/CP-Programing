/**
Monk loves to preform different operations on arrays, and so being the principal of Hackerearth School, he assigned a task to his new student Mishki.
Mishki will be provided with an integer array A of size N and an integer K , where she needs to rotate the array in the right direction by K steps and 
then print the resultant array. As she is new to the school, please help her to complete the task.

Input:
The first line will consists of one integer T denoting the number of test cases.
For each test case:
1) The first line consists of two integers N and K, N being the number of elements in the array and K denotes the number of steps of rotation.
2) The next line consists of N space separated integers , denoting the elements of the array A.

**/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
void ChangeArray(int low,int hig,int arr[]){
    while(low<hig){
        arr[low]=arr[low]^arr[hig];
        arr[hig]=arr[low]^arr[hig];
        arr[low]=arr[low]^arr[hig];
        low++;hig--;
    }
}
void printArray(int arr[],int n){
    for(int i=0;i<n;i++) cout<<arr[i]<<" ";
}
int main()
{
  int t;cin>>t;
  while(t--){
      int n,k;
      cin>>n>>k;
      k=k%n;
      int arr[n];
      for(int i=0;i<n;i++) cin>>arr[i];
      ChangeArray(0,n-k-1,arr);
      ChangeArray(n-k,n-1,arr);
      ChangeArray(0,n-1,arr);
      printArray(arr,n);
      cout<<"\n";
  }
   
   return 0;
}
