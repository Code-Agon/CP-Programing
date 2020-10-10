/**
https://cses.fi/problemset/task/1753/
Given a string and a pattern, your task is to count the number of positions where the pattern occurs in the string.
Input
The first input line has a string of length n, and the second input line has a pattern of length m. Both of them consist of characters a–z.
Output
Print one integer: the number of occurrences.

Constraints
1≤n,m≤106
Example

Input:
saippuakauppias
pp

Output:
2
**/

#include <iostream>
using namespace std;
int main()
{
    string str, pat;
    cin >> str >> pat;
    int patLen = pat.length();
    int strLen = str.length();
    int patArr[patLen];
    int i = 1, len = 0;
    patArr[0] = 0;
    while (i < patLen)
    {
        if (pat[i] == pat[len])
        {
            len++;
            patArr[i] = len;
            i++;
        }
        else
        {

            if (len == 0)
            {
                patArr[i] = 0;
                i++;
            }
            else
            {
                len = patArr[len - 1];
            }
        }
    }

    i = 0, len = 0;
    int count = 0;
    while (i < strLen)
    {
        if (str[i] == pat[len])
        {
            len++;
            i++;
        }
        else
        {
            if (len == 0)
            {
                i++;
            }
            else
            {
                len = patArr[len - 1];
            }
        }
        if (len == patLen)
        {
            count++;
        }
    }
    cout << count << "\n";

    return 0;
}
