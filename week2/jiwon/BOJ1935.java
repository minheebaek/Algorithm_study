import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 후위 표기식을 저장, 피연산자는 A부터 순서대로 N개의 영대문자만이 사용
        char[] array = br.readLine().toCharArray();
        
        Stack<Double> stack = new Stack<>();

        // 키-값으로 구성된 Map 선언
        Map<Character, Double> map = new HashMap<>();

        // N의 개수만큼 피연산자에 대응되는 값을 설정
        char key = 'A';
        for (int i = 0; i < n; i++) {
            map.put(key, Double.parseDouble(br.readLine()));
            key++;
        }

        for (int i = 0; i < array.length; i++) {
            // 인덱스의 값이 a-z인 경우
            if ('A' <= array[i] && array[i] <= 'Z') {
                stack.push(map.get(array[i]));
            } else {
                double answer1 = stack.pop();
                double answer2 = stack.pop();

                switch (array[i]) {
                    case '+':
                        stack.push(answer2 + answer1);
                        break;
                    case '-':
                        stack.push(answer2 - answer1);
                        break;
                    case '*':
                        stack.push(answer2 * answer1);
                        break;
                    case '/':
                        stack.push(answer2 / answer1);
                        break;
                }
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
    }
}
