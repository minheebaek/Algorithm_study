import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;
    static int[] wines; // 포도주 양 배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 포도주 잔의 개수
        wines = new int[n+1];
        dp = new Integer[n + 1];

        for (int i = 1; i < n+1; i++){
            wines[i] = Integer.parseInt(br.readLine()); // 포도주 양 저장
        }
        dp[0] = 0;
        dp[1] = wines[1];
        if (n > 1){
            dp[2] = wines[1] + wines[2];
        }

        System.out.println(find(n));
    }

    public static int find(int n){
        if (dp[n] == null){
            dp[n] = Math.max(find(n-2)+wines[n], Math.max(find(n-1), dp[n-3]+wines[n-1]+wines[n])); // 어려워,,
        }
        return dp[n];
    }
}
