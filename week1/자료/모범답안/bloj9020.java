import java.util.Scanner;

public class Main {
    public static boolean[] prime = new boolean[10001];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        get_prime();

        int T = in.nextInt();	// 테스트케이스

        while (T-- > 0) {
            int n = in.nextInt();
            int first_partition = n / 2;
            int second_partition = n / 2;

            while (true) {

                // 두 파티션이 모두 소수일 경우
                if (!prime[first_partition] && !prime[second_partition]) {
                    System.out.println(first_partition + " " + second_partition);
                    break;
                }
                first_partition--;
                second_partition++;
            }
        }

    }