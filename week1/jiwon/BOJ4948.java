package study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            boolean[] isPrime = new boolean[((n * 2) + 1)];
            isPrime[0] = isPrime[1] = true;
            for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
                if (isPrime[i]) continue;
                for (int j = (i * i); j < isPrime.length; j += i) {
                    isPrime[j] = true;
                }
            }

            int count = 0;
            for (int i = (n + 1); i <= (n * 2); i++) {
                if (!isPrime[i]) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
