/**
https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/A
Implement a binary search algorithm.
**/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int
search_r (int arr[], int n, int k)
{
  int ma = -1;
  int lo = 0, hig = n - 1;
  while (lo <= hig)
    {
      int mid = lo + (hig - lo) / 2;
      if (arr[mid] <= k)
	{
 
	  lo = mid + 1;
	  ma = mid;
	}
      else
	hig = mid - 1;
    }
  return ma + 1;;
}
int
search (int arr[], int n, int k)
{
  int ma = -1;
  int lo = 0, hig = n - 1;
  while (lo <= hig)
    {
      int mid = lo + (hig - lo) / 2;
      if (arr[mid] <k)
	{
 
	  lo = mid + 1;
	  
	}
      else{
          
	hig = mid - 1;
	ma=mid;
      }
    }
  return ma + 1;;
}
 
int
main ()
{
  int t, k;
  cin >> t;
  int arr[t];
  for (int i = 0; i < t; i++)
    cin >> arr[i];
    cin>>k;
    sort(arr,arr+t);
  for (int i = 0; i < k; i++)
    {
      int l,r;
      cin >> l>>r;
      int les = search_r(arr, t, r);
      int gret = search(arr,t,l);
      if(les==0 || gret==0) cout<<0<<" ";
      else cout << les-gret+1 << " ";
 
    }
 
  return 0;
}
