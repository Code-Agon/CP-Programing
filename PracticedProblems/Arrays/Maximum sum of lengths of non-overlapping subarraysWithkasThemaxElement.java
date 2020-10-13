/**
input: 
5 4
4 6 8 1 4
output:
[4] [1,4],[4] but 4 already present so length is [4]=1 + [1,4]=2 ==3
o/p: 3
**/

import java.io.*;
import java.util.*;
public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] inp = br.readLine().split(" ");
            int N = Integer.parseInt(inp[0]);
            int K = Integer.parseInt(inp[1]);
            int[] A = new int[N];
            String[] inp1 = br.readLine().split(" ");
            for(int i=0;i<N;i++)
            {
                A[i] = Integer.parseInt(inp1[i]);
            }
            long out_ = solve(N, K, A);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
    static long solve(int N, int k, int[] arr){
        long sum=0;
        for(int i=0;i<N;){
            int count=0,b=0;
            while(i<N && arr[i]<=k){
                count++;
                if(arr[i]==k) b=1;
                i++;
            }
            if(b==1){
                sum+=count;
            }
            while(i<N && arr[i]>k){
                i++;
            }
        }
        return sum;
    }
}
