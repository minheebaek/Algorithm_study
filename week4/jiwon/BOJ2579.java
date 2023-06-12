package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    static Integer sum[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sum = new Integer[N + 1];
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sum[0] = arr[0];
        sum[1] = arr[1];

        if(N >= 2) {
            sum[2] = arr[1] + arr[2];
        }


        System.out.println(stair(N));
    }

    static int stair(int N) {
        if(sum[N] == null) {
            sum[N] = Math.max(stair(N - 2), stair(N - 3) + arr[N - 1]) + arr[N];
        }
        return sum[N];
    }
}
