/**
Notice that, move from (x, y) to (x, y − x) or (x − y, y) does not change gcd of x and y and
move from (x, y) to (2 ∗ x, y) or (x, 2 ∗ y) increase our gcd by two or does not change. 
And I claim that (x, y) is reachable iff their gcd is the power of two (form 2 k for any non-negative integer k). 
Let (a, b) the cell from which we can reach (x, y). If a is even, we can reach (x, y) from ( a 2 , b) and vice-verse for b, 
so both a and b are odd. if a > b we can reach (x, y) from ( a+b 2 , b) (moves: ( a+b 2 , b), (a + b, b) and (a, b)) and vice-versa for a < b, so a = b. 
There is a only one pair of a, b that a = b, gcd(a, b) = 2 k and both of them are odd, it is (1, 1). So we can achieve every cell.
**/

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 2e5 + 14;
int main(){
    ios::sync_with_stdio(0), cin.tie(0);
    int q;
    cin >> q;
    while(q--){
        ll a, b;
        cin >> a >> b;
        cout << (__builtin_popcountll(__gcd(a, b)) == 1 ? "Yes" : "No") << '\n';
    }
}
