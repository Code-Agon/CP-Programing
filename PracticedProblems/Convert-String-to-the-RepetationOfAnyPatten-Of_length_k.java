/**
You are given a integer k and a stiring S that contains lowercase alphabets of length N, where N is always a multiple of k. You are required to convert the given string 
to a "Special String"
A special string is a string that follows a repeating pattern of k character till the total lenth of the string is N.

For Example : 
S = abcdef  and k = 2, then the special string can be ababab or any other string bcbcbcor any other string that follows the mentioned criteria.
In order to convert the string, you can perform an operation on the string. Considering the lower english are set to circular. You can rotate the
character of the string on either side in one operation. For Example a you can rotate to b or . you can perform=m this operation any number of times on
any character of the string. Performing this operation once cost you 1 unit. Your tast is to convert. Your task is to convert the given string to special
string in minimum cost.

constrainsts:

1 <= t<= 10

1 <= k < = 100

1 <= N <= 10^6 


Sample input               Output

3
3 abcdefghi                 18
3 abcababc                   0
3 abcdefabc                  9

**/




import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
         Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         for(int i=0;i<t;i++){
             int n = sc.nextInt();
             String str= sc.next();
             int len = str.length();
             long sol = 0;
             for(int j=0;j<n;j++){
                sol+=check(str,j,n);
             }
             System.out.println(sol);
         }

    }
    public static long check(String str,int inti,int n){
        int arr[] = new int[27];
        for(int i=inti;i<str.length();i=i+n){
            arr[str.charAt(i)-'a']++;
        }
        long sol=Long.MAX_VALUE;
        for(int i=0;i<27;i++){
            long tot=0;
            if(arr[i]>0){
                for(int j=0;j<27;j++){
                    if(arr[j]>0 && j!=i){
                        if(i<j)
                        tot+=Math.min(Math.abs(i-j),Math.abs(i+25-j+1))*arr[j];
                        else{
                            tot+=Math.min(Math.abs(i-j),Math.abs(j+25-i+1))*arr[j];
                        }
                    } 
                }
                sol=Math.min(sol,tot);
            }
        }
        return sol;
    }
}
Conv
