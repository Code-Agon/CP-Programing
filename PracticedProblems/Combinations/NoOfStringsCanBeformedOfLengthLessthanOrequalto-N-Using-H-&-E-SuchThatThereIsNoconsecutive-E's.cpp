/**
Aniruddha loves to code on HackerEarth. There are some type of problems which he likes the most.
Problems are tagged with non empty strings containing only 'H' or 'E' or both. But he likes the problems tagged with strings
containing no consecutive E's. Given an integer N, find maximum number of problems Aniruddha may like which are tagged with strings of length less than or equal to N.

Input
First line contains single integer, T, the number of test cases. Each of next T lines contains single integer N.

Output
For each test case output single integer, the answer to the problem i.e maximum number of problems 
Aniruddha may like which are tagged with strings of length less than or equal to N. Output answer modulo 109 + 7 (i.e. 1000000007).

Constraints
1 ≤ T ≤ 10^6
1 ≤ N ≤ 10^6

SAMPLE INPUT 
2
2
3
SAMPLE OUTPUT 
5
10
**/

#include <iostream>
using namespace std;
int main()
{
    long arr[1000001];
    
    long h=1,e=1;
    arr[1]=2;
    for(int i=2;i<1000001;i++){
            long k = ((h*2)+e)%1000000007;
            arr[i]=(arr[i-1]+k)%1000000007;
            long f=h;
            long m=e;
            e=(f)%1000000007;
            h=(h+m)%1000000007;
            
            
    }
  int t;
  cin>>t;
  while(t--){
      int k;
      cin>>k;
      cout<<(arr[k])%1000000007<<"\n";
  }
   return 0;
}
              Editorial
/*****************************************/
/**
To solve this problem, if you try small cases by hand it turns out that, number of problems Aniruddha may like for a given n 
follows Fibonacci series which starts with 2. Now, as we need to find the number of problems Aniruddha may like for i = 1 to n, 
i.e we need to find the sum of 1st n Fibonacci numbers where the series starts with 2. Now, the sum of first n Fibonacci numbers is (n+2)th Fibonacci number - 1.
But as the series starts with 2 the ans = F(n+2) - 3 where F(n+2) denotes the (n+2)th Fibonacci number. You can either use this formula directly
(where you will find nth Fibonacci number using Matrix Exponentiation) or as n is till 106 we can pre-compute the ans.
For more details refer to Setter and Tester's solution.


**/

int fib[1000006];
void precalc()
{
	int i;
	fib[0] = fib[1] = 1;
	FOR(i, 2, 1000005)
		fib[i] = (fib[i-1] + fib[i-2])%MOD;
	FOR(i,0,1000000)
		fib[i] = (fib[i] + fib[i+1])%MOD;
	FOR(i,1,1000000)
		fib[i] = (fib[i] + fib[i-1])%MOD;
}
main()
{
    st_clk
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int t,i,j;
    precalc();
    cin>>t;
    assert(t>=1 && t<=1000000);
    while (t--)
    {
    	int n;
    	cin>>n;
    	assert(n>=1 && n<=1000000);
    	cout<<fib[n-1]<<endl;
    }
    return 0;
}
