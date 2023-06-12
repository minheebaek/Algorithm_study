package study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
    static int[][] arr;
    static Integer[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(find(0, 0));
    }

    static int find(int x, int y) {
        // 마지막 행일 경우 현재 위치의 dp값 반환
        if(x == N - 1) return dp[x][y];

        // 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
        if (dp[x][y] == null) {
            dp[x][y] = Math.max(find(x + 1, y), find(x + 1, y + 1)) + arr[x][y];
        }
        return dp[x][y];
    }
}
