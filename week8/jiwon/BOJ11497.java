package study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11497 {
    static int T, N;
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T > 0) {

            N = Integer.parseInt(br.readLine());
            int answer = Integer.MAX_VALUE;
            arr = new int[N];

            String[] t = br.readLine().split(" ");
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(t[i]);
            }

            int sort[] = new int[N];
            int left = 0;
            int right = N - 1;

            Arrays.sort(arr);

            for(int i = 0; i < N; i++) {
                if(i % 2 != 0) {
                    sort[left] = arr[i];
                    left++;
                }
                else {
                    sort[right] = arr[i];
                    right--;
                }
            }

            answer = Math.abs(sort[0] - sort[N - 1]);

            for (int i = 1; i < N; i++) {
                answer = Math.max(answer, Math.abs(sort[i]-sort[i-1]));
            }

            T--;

            System.out.println(answer);
        }
    }
}
