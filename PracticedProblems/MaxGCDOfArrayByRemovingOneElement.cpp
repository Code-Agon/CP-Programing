/**
Given a Array (a1,a2,a3,....an), you have to remove one element from array such that gcd of remaning elements is maximum


contraints:

2<= n < = 2*10^5
1<= ai <= 10^9

**/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int MaxGCD(int a[],int n){
    int Prefix[n + 2]; 
    int Suffix[n + 2];
    Prefix[1] = a[0]; 
    for (int i = 2; i <= n; i += 1) { 
        Prefix[i] = __gcd(Prefix[i - 1], a[i - 1]); 
    } 
    Suffix[n] = a[n - 1]; 
    for (int i = n - 1; i >= 1; i -= 1) { 
        Suffix[i] = __gcd(Suffix[i + 1], a[i - 1]); 
    } 
    int ans = max(Suffix[2], Prefix[n - 1]); 
    for (int i = 2; i < n; i += 1) { 
        ans = max(ans, __gcd(Prefix[i - 1], Suffix[i + 1])); 
    } 
    return ans; 
}
int main()
{
   int n;
   cin>>n;
   int arr[n];
   for(int i=0;i<n;i++) cin>>arr[i];
   int ma=MaxGCD(arr,n);
   cout<<ma<<"\n";
   return 0;
}
