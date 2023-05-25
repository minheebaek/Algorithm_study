import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ11625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        long num = 0;
        for (Long key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                num = key;
            } else if (map.get(key) == max) {
                num = Math.min(num, key);
            }
        }
        System.out.println(num);
    }
}
