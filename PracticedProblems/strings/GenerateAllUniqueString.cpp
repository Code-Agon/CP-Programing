/**
Input:
aabac

Output:
20
aaabc
aaacb
aabac
aabca
aacab
aacba
abaac
abaca
abcaa
acaab
acaba
acbaa
baaac
baaca
bacaa
bcaaa
caaab
caaba
cabaa
cbaaa**/

#include <iostream>
typedef long long int ll;
using namespace std;
#include <bits/stdc++.h>
set<string> s;
void generate(string str, int arr[], vector<char> &v)
{
    if (v.size() == str.size())
    {
        string st = "";
        for (auto it : v)
        {
            st = st + it;
        }
        s.insert(st);
    }
    for (int i = 0; i < (int)str.size(); i++)
    {
        if (arr[i] == 0)
        {
            arr[i] = 1;
            v.push_back(str[i]);
            generate(str, arr, v);
            arr[i] = 0;
            v.pop_back();
        }
    }
}
int main()
{

    string str;
    cin >> str;
    vector<char> v;
    int arr[str.length()] = {0};
    generate(str, arr, v);
    cout << s.size() << "\n";
    for (auto it : s)
    {
        cout << it << "\n";
    }

    return 0;
}
