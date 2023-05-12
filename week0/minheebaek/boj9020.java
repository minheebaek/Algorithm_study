import java.io.*;

public class Main {
    static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {

        prime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            int p = n / 2;
            int q = n / 2;

            /*소수 아님= true
          소수 =false
          */

            while (true) {
                if (prime[p] == false && prime[q] == false) {
                    System.out.println(p + " " + q);
                    break;
                }
                p--;
                q++;
            }
            t--;
        }

        br.close();
    }

    //에라토스테네스 체
    public static void prime() {


        /*소수 아님= true
          소수 =false
          */

        prime[0] = prime[1] = true;

        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == true) continue;

            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}