/**
https://www.hackerearth.com/problem/algorithm/paint-wall-easy/description/
Bob got a new contract of painting wall. Wall has N bricks. Bob can paint each brick with three type of colors : Type A, Type B and Type C. 
Assume Bob has enough amount of paints of all three types. Find number of ways Bob can paint the wall having N bricks with color of Type A, Type B and Type C 
such that no two adjacent brick should have same color.

Input:

First line of input contains number of test cases T. Each test case contains a single integer N, number of bricks in wall.

Output:

For each test case print the number of ways Bob can paint the wall. Answer can be too large print answer modulo 109+7.

Constraints:
1 ≤ T ≤ 103
1 ≤ N ≤ 105

SAMPLE INPUT 
2
1
5
SAMPLE OUTPUT 
3
48
**/
#include <iostream>
using namespace std;
int main()
{
    long arr[100001];
    arr[0]=1;
    for(int i=1;i<100001;i++){
            arr[i]=(arr[i-1]*2)%1000000007;        
    }
  int t;
  cin>>t;
  while(t--){
      int k;
      cin>>k;
      cout<<(arr[k-1]*3)%1000000007<<"\n";
     
  }
   return 0;
}
