package study.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ11053DP {
    static int[] arr;
    static Integer[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        cnt = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 0 ~ N-1 까지 탐색
        for(int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = cnt[0];

        // 최댓값 찾기
        for(int i = 1; i < N; i++) {
            max = Math.max(max, cnt[i]);
        }
        System.out.println(max);
    }


    static int LIS(int N) {

        // 만약 탐색하지 않던 위치의 경우
        if(cnt[N] == null) {
            cnt[N] = 1;	// 1로 초기화

            for(int i = N - 1; i >= 0; i--) {
                if(arr[i] < arr[N]) {
                    cnt[N] = Math.max(cnt[N], LIS(i) + 1);
                }
            }
        }
        return cnt[N];
    }
}
