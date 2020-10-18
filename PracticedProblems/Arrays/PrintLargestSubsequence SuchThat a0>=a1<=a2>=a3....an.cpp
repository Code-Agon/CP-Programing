/**
 M is again playing with his array a1,a2,a3,a4...an  (as playing with his array is the only choice),
 he wants to choose a subsequence of array likeb1,b2,b3....bm  that .
b1>=b2<=b3>=b4.....<=bm
What is the maximum length of subsequence that M can choose which satisfies above condition?

Subsequence of an array can be obtained by erasing some (possibly zero) elements from the array. You can erase any elements, not necessarily going successively. The remaining elements preserve their order.

Input

First line contains only n, length of array.

Second line contains the array elements separated by a1,a2,a3...an space.

1<=n<=3*10^5
1<=ai<=3*10^5

Output

The only line of output contains an integer, the maximum length of subsequence that M can choose.

SAMPLE INPUT 
10
5 7 11 13 19 17 8 4 10 19

SAMPLE OUTPUT 
3 ((5,4,9) or (7,4,9) ..) but max is 3
**/
#include <iostream>
using namespace std;
int main()
{
    int n;
    cin >> n;
    int k = 0, len = 1;
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    for (int i = 1; i < n; i++)
    {
        if (k == 0)
        {
            if (arr[i] <= arr[i - 1])
            {
                len++;
                k = 1;
            }
        }
        else
        {
            if (arr[i] >= arr[i - 1])
            {
                len++;
                k = 0;
            }
        }
    }
    cout << len << "\n";
    return 0;
}
