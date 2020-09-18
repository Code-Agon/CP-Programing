
bool prime[1000001];
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
  
    // Print all prime numbers 
   // for (int p=2; p<=n; p++) 
     //  if (prime[p]) 
        //  cout << p << " "; 
} 
void getPrimes(int n){
  SieveOfEratosthenes(n);
  for(int i=2;i<=n;i++){
      if(prime[i]) v.push_back(i);
    }
}
