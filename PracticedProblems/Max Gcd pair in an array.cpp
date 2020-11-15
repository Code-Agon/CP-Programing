
/**
You are given an array of n positive integers. Your task is to find two integers such that their greatest common divisor is as large as possible.

Input

The first input line has an integer n: the size of the array.

The second line has n integers x1,x2,…,xn: the contents of the array.

Output

Print the maximum greatest common divisor.

Constraints
2≤n≤2⋅105
1≤xi≤106
Example

Input:
5
3 14 15 7 9

Output:
7
**/
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int arr[n], brr[1000001] = {0};
    int ma = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        brr[arr[i]]++;
        ma = max(ma, arr[i]);
    }
    int count = 0;
    bool bo = true;
    for (int i = ma; i >= 1 && bo; i--)
    {
        int j = i;
        while (j <= ma)
        {
            if (brr[j] > 0)
                count += brr[j];

            if (count >= 2)
            {
                cout << i << "\n";
                bo = false;
                break;
            }
            j = j + i;
        }
        count = 0;
    }

    return 0;
}
