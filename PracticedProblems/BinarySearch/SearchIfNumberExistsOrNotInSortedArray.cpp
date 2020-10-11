/**
https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/A
Implement a binary search algorithm.
**/

#include <iostream>
 
using namespace std;
bool
search (int arr[], int n, int k)
{
  int lo = 0, hig = n - 1;
  while (lo <= hig)
    {
      int mid = lo + (hig - lo) / 2;
      if (arr[mid] == k)
	return true;
      if (arr[mid] < k)
	lo = mid + 1;
      else
	hig = mid - 1;
    }
  return false;
}
 
int
main ()
{
  int t, k;
  cin >> t >> k;
  int arr[t];
  for (int i = 0; i < t; i++)
    cin >> arr[i];
  for (int i = 0; i < k; i++)
    {
      int g;
      cin >> g;
      bool bo = search (arr, t, g);
      if(bo) cout<<"YES\n";
      else cout<<"NO\n";
    }
 
  return 0;
}
