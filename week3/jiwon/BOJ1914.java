import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hanoi {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }
    public static void hanoi (int N, int a, int b, int c) {
        if (N == 0)	return;

        count++;

        hanoi(N-1, a, c, b);
        sb.append(a + " " + c + "\n");
        hanoi(N-1, b, a, c);
    }
}
