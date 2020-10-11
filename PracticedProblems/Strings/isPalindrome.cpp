#include <iostream>

using namespace std;
bool isPalindeome(string str){
    int low=0,hig=str.length()-1;
    while(low<hig){
        if(str[low]==str[hig]) {
            low++;
            hig--;
        }else return false;
    }
    return true;
}
int main()
{
 
    string str;
    cin>>str;
    if(isPalindeome(str)){
        cout<<"Palindrome";
    }else cout<<"Not Palindrome"; 
   return 0;
}
