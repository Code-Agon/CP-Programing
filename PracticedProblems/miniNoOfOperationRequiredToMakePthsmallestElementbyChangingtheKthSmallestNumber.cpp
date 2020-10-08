/**
You are given an array of N integers A1,A2,…,AN and three more integers X,p, and k.

An operation on the array is defined to be: replace the k-th smallest integer in the array with any integer you want.

Output the minimum number of operations you must perform on the array (possibly 0 operations) to make the p-th smallest element
of the array equal to X. If it is impossible to do so output −1.

Note: the k-th smallest number in an array is the k-th number from the left when the array is sorted in non-decreasing order.
Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains four integers N,X,p,k respectively.
The second line contains N space-separated integers A1,A2,…,AN.
Output
For each test case, print a single line containing one integer ― the minimum number of operations you must perform to make X the p-th smallest element or −1 if its impossible to do so.

Constraints
1≤T≤100
1≤p,k≤N
0≤X≤109
The sum of N over all test cases does not exceed 4∗105
0≤Ai≤109 for each valid i

**/
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int check(int arr[], int n, int x, int p, int k)
{
    if (arr[p] == x)
        return 0;
    int count = 0;
    if (k > p)
    {
        if (arr[p] < x)
            return -1;
        while (arr[p] > x && p >= 1)
        {
            count++;
            p--;
        }
    }
    else if (k < p)
    {
        if (arr[p] > x)
            return -1;
        while (arr[p] < x && p <= n)
        {
            count++;
            p++;
        }
    }
    else
    {

        if (arr[p] > x)
        {
            while (arr[p] > x && p >= 1)
            {
                count++;
                p--;
            }
        }
        else
        {
            while (arr[p] < x && p <= n)
            {
                count++;
                p++;
            }
        }
    }
    return count;
}
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, x, p, k;
        cin >> n >> x >> p >> k;
        int arr[n], brr[n + 5];
        for (int i = 0; i < n; i++)
            cin >> arr[i];
        sort(arr, arr + n);
        for (int i = 0; i < n; i++)
            brr[i + 1] = arr[i];
        int sol = check(brr, n, x, p, k);
        cout << sol << "\n";
    }
    return 0;
}
