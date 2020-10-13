#include <iostream>

using namespace std;
int noOfVovles(string str){
    int count=0;
    for(int i=0;i<str.length();i++){
        if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u') count++;
    }
    return count;
}
int main()
{
 
    int t;cin>>t;
    while(t--){
    string str;
    cin>>str;
    cout<<noOfVovles(str)<<"\n"; 
    }
    
   return 0;
}
