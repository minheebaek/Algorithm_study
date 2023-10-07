import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] numarr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        primeNumber(); //메서드 호출
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count=0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(numarr[num] != 0) {
                count++;
            }
        }
        System.out.print(count);
    }

    static void primeNumber() {
        numarr = new int[1001];

        for (int i = 2; i < numarr.length; i++) {
            numarr[i] = i;
        }
        for (int i = 2; i < numarr.length; i++) {
            if (numarr[i] == 0) continue;

            for (int j = i + i; j < numarr.length; j += i) {
                numarr[j] = 0;
            }
        }
    }
}