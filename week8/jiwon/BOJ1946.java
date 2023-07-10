package study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1946 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken()); // 서류
                int r2 = Integer.parseInt(st.nextToken()); // 면접
                arr[r1] = r2; // 중복되지 않으므로 정렬할 필요 x
            }

            int rank = arr[1];
            int answer = 1;

            for (int i = 2; i <= N; i++) {
                if (rank > arr[i]) {
                    answer++; // 등수가 더 높다는 뜻이니까 그 전 등수 사람들이랑은 또 안 비교해도 됨
                    rank = arr[i];
                }
            }
            System.out.println(answer);
        }
    }
}
