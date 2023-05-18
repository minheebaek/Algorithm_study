import java.io.*;
import static java.lang.Math.sqrt;
// java 제곱근 구하는 메소드 Math 클래스의 sqrt() 메소드

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= sqrt(N); i++){  // 2부터 N의 제곱근까지 나눴을 때 나머지가 0이면 N의 인수
            while(N % i == 0){
                sb.append(i).append('\n');
                N /= i;
            }
        }

        if (N!= 1){        // 소인수가 제곱근보다 큰 경우 반복문의 범위에서 제외되므로 추가해줌. (ex. 34에서 17)
            sb.append(N);
        }
        System.out.println(sb);
    }
}

/* 이해하기
* 12라인 for문에서 제곱근으로 돌리더라도 i에 소수가 아닌 숫자가 들어가는 경우가 있는데? (ex. 4)
* => 2부터 시작해서 while문에서 2로 나눠서 나머지가 0이되는 경우가 끝나기 전까지 while반복이 끝나지 않아서 4로 나눠서 0이 나머지가 되는 경우 남아있지 않음
* => 즉, 소수의 배수에서 나눠서 나머지가 0이되는 경우는 남아있지 않음. 그 전에 소수에서 다 나눠버림
* 
* 제곱근으로 범위를 설정하는 이유는
* 어떤 N이 두 개 이상의 인수 곱셈으로 나타낼 수 있을 때 적어도 한 개 이상은 반드시 N의 제곱근보다 작거나 같다.
* 
*/
