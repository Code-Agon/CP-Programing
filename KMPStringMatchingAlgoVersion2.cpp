#include <iostream>

using namespace std;

int main()
{
   string str,pat;
   cin>>str>>pat;
   int Len = pat.length();
   int patLen = pat.length()+str.length()+1;
   pat=pat+'$'+str;
   int patArr[patLen];
  int i=1,len=0,count=0;
  patArr[0]=0;
  while(i<patLen){
      if(pat[i]==pat[len]){
          len++;
          patArr[i]=len;
          i++;
      }else{
          if(len==0){
              patArr[i]=0;
              i++;
          }else{
              len=patArr[len-1];
          }
      }
  }
  for(int i=0;i<patLen;i++) {
      if(patArr[i]==Len) count++;
  }
  cout<<count<<"\n";
   return 0;
}
