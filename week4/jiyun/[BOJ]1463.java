// TIL: Math.min 인자 순서 -> 시간에 영향
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;

        System.out.println(find(n));
    }

    public static int find(int n){
        if (dp[n] == null){
            // 6으로 나눠지는 경우
            if (n % 6 == 0){
                dp[n] = Math.min(find(n -1), Math.min(find(n / 3), find(n / 2))) + 1;
            }
            // 3으로 나눠지는 경우
            else if (n % 3 == 0){
                dp[n] = Math.min(find(n / 3), find(n - 1) ) +1;
            }
            // 2로 나눠지는 경우
            else if (n % 2 == 0){
                dp[n] = Math.min(find(n / 2), find(n -1)) +1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[n] = find(n -1) +1;
            }
        }
        return dp[n];
    }
}
