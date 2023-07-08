import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    list.addLast(arr[i]);
                } else {
                    list.addFirst(arr[i]);
                }
            }

            int[] res = new int[n];
            int idx = 0;
            for (int item : list) {
                res[idx++] = item;
            }

            int maxDiff = abs(res[0] - res[n - 1]);
            for (int i = 1; i < n; i++) {
                if (abs(res[i] - res[i - 1]) > maxDiff) {
                    maxDiff = abs(res[i] - res[i - 1]);
                }
            }

            System.out.println(maxDiff);
        }
    }

    static int abs(int n) {
        return n > 0 ? n : -n;
    }
}
