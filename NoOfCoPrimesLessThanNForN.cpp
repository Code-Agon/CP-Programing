
/**
https://www.hackerearth.com/problem/algorithm/roys-boolean-function-1/
**/
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
bool prime[1000001];
vector<int> v;
void SieveOfEratosthenes(int n)
{
    memset(prime, true, sizeof(prime));
    prime[1]=false;
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
int NoOfCoPrimesLessThanNForN(int n){
	int k=n;
	int tot=n;
	for(auto it:v){
        if(k<=1) return tot;
		int count=0;
		if(prime[k]){
            tot=tot-tot/k;
			return tot;
		}else{
			while(k%it==0 && k>1){
				k=k/it;
				count++;
			}
			if(count!=0){
				tot=tot-tot/it;
			}
		}
	}
	return tot;
}
int main() {
	getPrimes(100001);
	int t;
	cin>>t;
	while(t--){
		int n;
        cin>>n;
		    int tot= NoOfCoPrimesLessThanNForN(n);
        cout<<tot<<"\n";
	}
	return 0;
}
