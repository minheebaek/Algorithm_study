package study.week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1783 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        if (N == 1) {
            answer = 1;
        } else if (N == 2) {
            // 주어진 방향 다 움직일 수 없음. 2, 3번 반복만 가능
            answer = Math.min((M + 1) / 2, 4); // 방문할 수 있는 칸 최대 4개
        } else if (N >= 3) {
            if (M < 7) {
                // 1, 4번 방향만 반복 가능
                answer = Math.min(M, 4); // 방문할 수 있는 칸 최대 4개
            } else { // 모든 방향 다 이동 가능
                answer = M - 2;
            }
        }
        System.out.println(answer);
    }
}
