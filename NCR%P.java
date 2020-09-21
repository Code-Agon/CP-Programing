import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
static long mod = 1000000007l;
public static long pow(long k, long  p){
    
    long sum=1l;
    while(p>0){
        if(p%2==1){
            sum=(sum*k)%mod;
        }
        k=(k*k)%mod;
        p=p>>1;
    }
    return sum%mod;
    
    
}

    public static void main(String[] args)throws IOException {
       long fac[] =new long[2001];
       long inv[] = new long[2001];
        fac[0]=1;
        inv[0]=1;
    for(int i=1;i<2001;i++) fac[i]=(fac[i-1]*i)%mod;
    for(int i=1;i<2001;i++) inv[i]=pow(fac[i],1000000005);
        StringBuffer sb = new StringBuffer();
       BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        for(int i=0;i<n1;i++){
            String str[] = br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int r=Integer.parseInt(str[1]);
            if(n==0 || r>n) sb.append("0\n");
        else{

            long ans=fac[n]%mod;
                ans=(ans*inv[r])%mod;
                ans=(ans*inv[n-r])%mod;
            
            sb.append(ans+"\n");
        }
        }
        System.out.println(sb.toString().trim());
    }
}
