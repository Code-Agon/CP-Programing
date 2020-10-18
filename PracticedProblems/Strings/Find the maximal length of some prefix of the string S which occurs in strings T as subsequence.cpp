/**
https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/prefpref/
You are given two string S and T. Find the maximal length of some prefix of the string S which occurs in strings T as subsequence.

Input
The first line contains string S. The second line contains string T. Both strings consist of lowecase Latin letters.

Output
Output one integer - answer to the question.

Constraints
1 <= length of S, T <= 106

SAMPLE INPUT 
digger
biggerdiagram
SAMPLE OUTPUT 
3
**/
#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int main()
{
    string str,str2;
    cin>>str>>str2;
    int len = str.length();
    int len2 = str2.length();
    int j=0;
    for(int i=0;i<len2 && j<len ;i++){
        if(str[j]==str2[i]){
            j++;
        }
    }
    cout<<j<<"\n";

    return 0;
}
