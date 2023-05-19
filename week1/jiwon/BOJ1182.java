package study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제
//N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
// 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
//
//출력
//첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
public class BOJ1182 {
    static int N, S;
    static int[] arr;
    static boolean[] isChecked;
    static int[] nArr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isChecked = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // i: 조합 중 몇 개를 고를지
        for (int i = 1; i <= N; i++) {
            nArr = new int[i];
            backTracking(0, 0, i);
        }

        System.out.println(cnt);
    }

    static void backTracking(int start, int depth, int limit) {
        if(depth == limit) {
            int sum = 0;
            for(int val : nArr) { // 배열에 넣은 값들을 모두 꺼내서 더해준다.
                sum += val;
            }
            if(sum == S) {
                cnt++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                nArr[depth] = arr[i];
                backTracking(i, depth + 1, limit);
                isChecked[i] = false;
            }
        }
    }
}
