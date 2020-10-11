/**
Given an array of integers size n (a1,a2,a3.....an-1,an) find the maximum AND Pair, i!=j and 1<=i<=j<=n

constraints : 
  1<=n<=3*10^5
  1<=arr[i]<=10^9

**/


import java.util.*;
public class HelloWorld{

     public static void main(String []args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int arr[] = new int[n];
       for(int i=0;i<n;i++){
           arr[i] = sc.nextInt();
       }
       int l=Check(arr,n);
       System.out.println(l);
       
     }
     public static int Check(int arr[],int n){
         int pow[] = new int[31];
         pow[0]=1;
         for(int i=1;i<31;i++){
             pow[i]=pow[i-1]*2;
         }
        int sum=0;
        for(int i=30;i>=0;i--){
            int count=0;
            for(int j=0;j<n;j++){
                if((arr[j]&(pow[i]+sum))==(pow[i]+sum)){
                    count++;
                }
            }
            if(count>=2){
                sum+=pow[i];
            }
        }
         return sum;
     }
     
}
