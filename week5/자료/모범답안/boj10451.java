import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr, check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t --> 0) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n];
            check = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            k = 0;
            for(int i = 0; i < n; i++) {
                if(check[i] == 0) {
                    k++;
                    dfs(i);
                }
            }

            sb.append(k).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int node) {
        check[node] = k;
        int next = arr[node];

        if(check[next] == 0) {
            dfs(next);
        }
    }
}