import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int s1 = sum(o1);
                    int s2 = sum(o2);
                    if (s1 == s2) {
                        return o1.compareTo(o2);
                    }
                    return s1 - s2;
                } else {
                    return o1.length() - o2.length();
                }
            }
          
            public int sum(String s) {
                int sum = 0;
                for (int i = 0; i < s.length(); i++) {
                    int c = s.charAt(i) - '0';
                    if (c >= 0 && c <= 9) {
                        sum += c;
                    }
                }
                return sum;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "\n");
        }

        System.out.println(sb);
    }
}
