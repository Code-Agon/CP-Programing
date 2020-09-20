#include <iostream>
#include<bits/stdc++.h>
using namespace std;

bool prime[1000100];
vector<int> v;
void SieveOfEratosthenes(int n) 
{ 
    memset(prime, true, sizeof(prime)); 
  
    for (int p=2; p*p<=n; p++) 
    { 
        if (prime[p] == true) 
        { 
            for (int i=p*p; i<=n; i += p) 
                prime[i] = false; 
        } 
    } 
  
} 
void getPrimes(int n){
  SieveOfEratosthenes(n);
  for(int i=2;i<=n;i++){
      if(prime[i]) v.push_back(i);
    }
}
int main() {
    int t;
    cin>>t;  
    getPrimes(1000001);
    while(t--){
        vector<int> count;
        long n;
        cin>>n;
        int i=0;
        while(n>1 && v[i]<=n && i<v.size()){
                int c=0;
                if(prime[n]){
                    count.push_back(1);
                    n=1;
                }
                while(n%v[i]==0){
                    n=n/v[i];
                    c++;
                }
                if(c!=0) count.push_back(c);
                i++;
        }
        if(n>1) count.push_back(1);
        int sol=1;
        for(auto i:count){
            sol=sol*(i+1);
        }
        No of total divisors//cout<<sol<<"\n";
       No of Non-prime Divisors //cout<<sol-count.size()<<"\n";
    }


}
