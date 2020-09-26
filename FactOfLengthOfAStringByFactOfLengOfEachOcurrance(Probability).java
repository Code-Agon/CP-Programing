import java.io.*;
import java.util.*;

public class DemoSolution {
    static long mod = 1000000007l;

    public static long pow(long k, long p) {

        long sum = 1l;
        while (p > 0) {
            if (p % 2 == 1) {
                sum = (sum * k) % mod;
            }
            k = (k * k) % mod;
            p = p >> 1;
        }
        return sum % mod;

    }
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = str.length() + 5;
        long fac[] = new long[num];
        long inv[] = new long[num];
        fac[0] = 1;
        inv[0] = 1;
        for (int i = 1; i < num; i++)
            fac[i] = (fac[i - 1] * i) % mod;
        Arrays.fill(inv, -1l);
        // for(int i=1;i<num;i++) inv[i]=pow(fac[i],1000000005);
        int arr[] = new int[32];
        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i) - 'a']++;
        long ans = fac[str.length()];
        for (int i = 0; i < 32; i++) {
            if (inv[arr[i]] != -1)
                ans = (ans * inv[arr[i]]) % mod;
            else {
                inv[arr[i]] = pow(fac[arr[i]], 1000000005);
                ans = (ans * inv[arr[i]]) % mod;
            }

        }
        sb.append(ans + "\n");
        System.out.println(sb);
    }
}
