package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int cnt[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt[0] = 1;

        for (int i = 1; i < n; i++) {
            cnt[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && cnt[i] <= cnt[j]) {
                    cnt[i] = cnt[j] + 1;
                }
            }
        }

        int max = 0;
        for (int c : cnt) {
            max = Math.max(max, c);
        }

        System.out.println(max);
    }
}
