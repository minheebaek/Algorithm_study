// 하노이 탑

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //원판 개수

        /* BigInteger.TWO.pow(n) 는 '2'를 'n'번 곱한 값을 나타낸다.
           TWO가 '2'를 나타내는 BigInteger의 상수이다.
           BigInteger.ONE 은 '1'을 나타내는 BigInteger의 상수이다.
           subtract는 뺄셈 연산을 의미한다.
           따라서 BigInteger.TWO.pow(n).subtract(BigInteger.ONE) 는
           ('2'를 'n'번 곱한 값) 에서 '1'을 빼는 것을 의미한다.
           이것은 하노이 탑의 원판 이동 횟수( 2ⁿ -1 )이다.
         */
        System.out.println(BigInteger.TWO.pow(n).subtract(BigInteger.ONE)); // 원판 이동 횟수 출력
        if(n < 21) { // n이 20 이하인 경우에만 과정을 출력하라고 했음
            hanoi(1, 3, n); //from 기둥에서 to 기둥으로 n개의 원판을 이동하는 메서드 호출
            System.out.print(sb);
        }
    }

    public static int hanoi(int from, int to, int n) {
        if(n == 1) { // 원판이 1개일 경우에는 가장 작은 원판을 from기둥에서 to 기둥으로 바로 옮긴다.
            sb.append(from + " " + to).append("\n");
            return 0;
        }
        // n이 1이 아닌 경우에는 임시기둥으로 'n-1'개의 원판을 옮긴다.
        // 임시기둥이 6에서 빼는 이유는 하노이 탑의 기둥 번호가 1,2,3으로 주어지기 때문이다.
        hanoi(from ,6 - from - to, n - 1);
        sb.append(from + " " + to).append("\n"); // 가장 큰 원판을 from -> to 기둥으로 옮긴다.
        hanoi(6 - from - to, to, n - 1); // 임시기둥에 옮겨뒀던 'n-1'개의 원판을 to로 옮긴다.
        return 0;
    }
}
