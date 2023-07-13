package study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T -- > 0) {
            int N = Integer.parseInt(br.readLine());
            int stocks[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i ++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            long answer = 0;

            for(int i = N - 1; i >= 0; i --) {
                if(stocks[i] > max) {
                    max = stocks[i];
                } else {
                    answer += max - stocks[i];
                }
            }
            System.out.println(answer);
        }
    }
}
