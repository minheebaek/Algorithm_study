/* 전위/중위/후위 표기식 (prefix/infix/postfix)
* 중위 표기식 : 3+2+4*5+3/1
* 전위 표기식 : ++3+2*45/31
* 후위 표기식 : 32+45*+31/+
*
* 스택을 사용해서 후위/전위 표기식 계산하기
* 후위 표기식
* 1. 숫자가 나오면 스택에 넣는다.
* 2. 연산자가 나오면 스택에서 두 수를 꺼내 계산하고 결과값을 스택에 넣는다.
* 전위 표기식
* 후위 표기식과 같은 방식으로 진행하되 식의 뒤에서 시작한다.
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 피연산자의 개수
        String postfix = br.readLine(); //후위 표기식

        int operand[] = new int[n]; //피연산자 배열
        for (int i=0; i < n; i++){
            operand[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i=0; i < postfix.length(); i++){
            char ch = postfix.charAt(i);
            if('A'<= ch && ch <= 'Z'){ //피연산자는 스택에 넣기
                double d = operand[ch - 'A']; // 피연산자 배열에서 각 문자(A,B,C,...)에 해당하는 숫자 찾기
                stack.push(d);
            } else { //연산자는 스택에서 피연산자 두 개씩 꺼내서 계산하고 다시 넣기
                double d1 = stack.pop();
                double d2 = stack.pop();
                double d3 = 0.0;
                switch (ch){
                    case '+':
                        d3 = d2 + d1;
                        break;
                    case '-':
                        d3 = d2 - d1;
                        break;
                    case '*':
                        d3 = d2 * d1;
                        break;
                    case '/':
                        d3 = d2 / d1;
                        break;
                }
                stack.push(d3);
            }
        }
        System.out.printf("%.2f", stack.pop());

    }
}
