/**
You have a fraction a/b  that a<b , you are alone so you needs a sequence of fractions of length k that satisfy following conditions:

* For each fraction p/q in the sequence,p  must be less than q (p<q).
* The multiplication of fractions must be equal to a/b (for i = 1 to l mul(pi/qi)).
* 1<=p<=q<=10^18

input format:
a b k
Example:
1 3 2      1/2*2/3=1/3

o/p:
1 2
2 3

**/


#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
  int a,b,l;
  cin>>a>>b>>l;
  int k = b-a;
  long h = b-1;
  int f=l-k+1;
  int tot=l;
  if(l<=k){
      while(tot>0){
       if(tot==1){
          cout<<a << " "<< b<<"\n";
      }else{
          cout<< a <<" " << a+1<<"\n";
      }
      a++;   
      tot--;
      }
  }else{
      while(k>1){
      cout<< a <<" " << a+1<<"\n";
      a++;   
      k--;
      }
      while(f>1){
          cout<< h*(h+2) << " "<< (h*(h+2))+1<<"\n";
          h++;
          f--;
      }
      cout<< h <<" "<<h+1<<"\n";
      
  }
   return 0;
}
