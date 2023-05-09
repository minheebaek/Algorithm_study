import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        prime(num);
        br.close();
    }

    public static void prime(int num) {

        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                num = num / i;
                System.out.println(i);
            }

        }
    }

}