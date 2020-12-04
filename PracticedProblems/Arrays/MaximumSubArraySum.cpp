#include <iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
int main()
{

    int n;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    int i=0,j=0;
    int ma=0,sum=0;
    while(i<n){
        sum+=arr[i];
        if(sum>0){
            ma=max(ma,sum);
        }else{
            while(j<=i && sum<0){
                sum-=arr[j];
                j++;
                ma=max(ma,sum);
            }
        }
        i++;
    }
    cout<<ma<<" ";
    return 0;
}
