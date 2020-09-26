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
        int num = 1000001;
        long fac[] = new long[num];
        long inv[] = new long[num];
        Arrays.fill(inv, -1l);
        fac[0] = 1;
        inv[0] = 1;
        for (int i = 1; i < num; i++)
            fac[i] = (fac[i - 1] * i) % mod;
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        for (int i = 0; i < n1; i++) {
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);
            if (n == 0 || r > n)
                sb.append("0\n");
            else {
                if (inv[r] == -1) {
                    inv[r] = pow(fac[r], mod-2);
                }
                if (inv[n - r] == -1) {
                    inv[n - r] = pow(fac[n - r], mod-2);
                }

                long ans = (((fac[n] * inv[r]) % mod) * inv[n - r]) % mod;
                sb.append(ans + "\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
