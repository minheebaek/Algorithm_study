import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] sort = new int[N];

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = sort[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sort); //nlogn

        int num = 0;
        for(int n : sort) {
            if(!hashMap.containsKey(n)) {
                hashMap.put(n, num); //n
                num++;
            }
        }

        for(int key : arr) {
            int value = hashMap.get(key);
            sb.append(value).append(' ');
        }

        System.out.println(sb);
    }
}
