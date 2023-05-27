/* 숫자를 큐에 넣고 반복문으로 k번째숫자만 출력하고 이 외에는 다시 큐에 넣는 방식으로 풀이 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int k = Integer.parseInt(st.nextToken()); // 몇 번째

        Queue<Integer> queue = new LinkedList<>();
        List<String> ans = new ArrayList<String>(); //출력되는 순서대로 숫자 넣을 리스트
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++){ // 큐에 숫자를 차례로 넣는다.
            queue.add(i);
        }

        while(!queue.isEmpty()){ // 큐가 빌 때까지
            for (int i=1; i <= k; i++){ // k번째 숫자를 찾기위해서 k번 반복
                if (i == k){ //i가 k번 째이면
                    ans.add((queue.poll()).toString()); // ans에 해당 숫자 넣고 삭제
                    break;
                }
                queue.add(queue.poll()); // k번 째가 아니라면 뒤로 보냄
            }
        }
        String str = String.join(", ", ans);
        sb.append("<").append(str).append(">");

        System.out.println(sb);

    }
}
