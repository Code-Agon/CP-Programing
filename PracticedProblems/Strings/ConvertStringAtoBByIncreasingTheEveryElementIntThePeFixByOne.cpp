/**
Two strings A and  comprising of lower case English letters are compatible if they are equal or can be made equal by following this step any number of times:

Select a prefix from the string  (possibly empty), and increase the alphabetical value of all the characters in the prefix by the same valid amount. 
For example if the string is xyz and we select the prefix xy then we can convert it to yz by increasing the alphabetical value by 1. 
But if we select the prefix xyz then we cannot increase the alphabetical value.
Your task is to determine if given strings  and  are compatible.

Input format

First line: String  

Next line: String 

Output format

For each test case, print  if string  can be converted to string YES , otherwise print NO.
**/
#include <iostream>
using namespace std;
int main()
{
    string str, pat;
    cin >> str >> pat;
    int patLen = pat.length();
    int patArr[patLen];
    bool b = true;
    if (str.length() != pat.length())
    {
        b = false;
    }
    if (b)
    {
        for (int i = 0; i < patLen; i++)
        {
            patArr[i] = (pat[i] - 'a') - (str[i] - 'a');
            if (patArr[i] < 0 || (i > 0 && patArr[i] > patArr[i - 1]))
            {
                b = false;
                break;
            }
        }
    }
    if (b)
        cout << "YES";
    else
        cout << "NO";
    return 0;
}
