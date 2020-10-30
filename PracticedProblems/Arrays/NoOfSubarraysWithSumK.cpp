/**
NoOfSubarraysWithSumK


Given an array of n positive integers, your task is to count the number of subarrays having sum x.

Input

The first input line has two integers n and x: the size of the array and the target sum x.

The next line has n integers a1,a2,…,an: the contents of the array.

Output

Print one integer: the required number of subarrays.

Constraints
1≤n≤2⋅105
1≤x,ai≤109
Example

Input:
5 7
2 4 1 2 7

Output:
3
**/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {

	int n;
	cin >> n;
	long x, sum = 0;
	cin >> x;
	long arr[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int i = 0, j = 0, count = 0;
	while (i < n) {
		sum += arr[i];
		i++;
		while (sum > x) {
			sum -= arr[j++];
		}
		if (sum == x) {
			count++;
		}

	}
	cout << count << "\n";

	return 0;
}
