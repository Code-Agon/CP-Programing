/**
Alice got a message M. It is in an alien language. A string in an alien language is said to be valid if it contains the letter a or z. 
Alice decided to count the number of valid substrings of the message M. Help him to do this.
Two substrings are different if it occurs at different positions in the message.

Input
First line of the input contains the number of test cases T. It is followed by T lines. Each line has a single string M.

Output
For each test case, output a single number, the number of valid substrings.

Constraints
|M| <= 10^6
M contains only lower case latin latters, that is characters a to z.

Read the editorial here.

SAMPLE INPUT 
4
abcd
azazaz
abbzbba
flkjdh
SAMPLE OUTPUT 
4
21
22
0
**/
#include <iostream>
using namespace std;

int main()
{
    int t;
    cin>>t;
    while(t--){
        string str;
        cin>>str;
        int n=str.length();
        int k=n,count=0;
        long sum=0;
        for(int i=0;i<n;i++){
            if(str[i]=='a' || str[i]=='z'){
                count++;
                k--;
                sum+=count*(k)+count;
                count=0;
            }else{
                count++;
                k--;
            }
        }
        cout<<sum<<"\n";
    }
    
   
   return 0;
}
