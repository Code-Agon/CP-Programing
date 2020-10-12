/**
Mira has two strings S (text String) and P (Pattern String) and wants your help in a task she is not able to do.
Given two strings, one is a text string (S) and other is a pattern string (P). You have to find the indexes of all the occurrence of pattern string in the text string. For printing, Starting Index of a string should be taken as 1.

Note: Strings contain only lower case alphabets.

Input:
The first line of the input contains an integer 'T' denoting the total number of test cases. Then T test cases follow. Each test consists of two lines. The first line of each test case contains the text string. The second line of each test case contains the pattern string.

Output:
Print indexes all the occurrences of the pattern strings in the text string in a single line separated by spaces.
Print -1 if no pattern found.

Constraints:
1 <= T <= 100
1 <= |S| <= 10000
1 <= |P| <= Sizeof text String

Example:
Input :

2
batmanandrobinarebatfriends
bat
abcsdu
edu

Output :
1 18
-1
**/


#include <iostream>
using namespace std;
void kmp(string str,string pat){
    int patLen = pat.length();
    int strLen = str.length();
    int patArr[patLen];
    int i = 1, len = 0;
    patArr[0] = 0;
    bool b=true;
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
            b=false;
            cout << i-patLen+1 << " ";
        }
    }
    if(b)
    cout << -1 ;
    cout<<"\n";

}
int main()
{
    int t;
    cin>>t;
    while(t--){
    string str, pat;
    cin >> str >> pat;
    kmp(str,pat);
    }
    return 0;
}
