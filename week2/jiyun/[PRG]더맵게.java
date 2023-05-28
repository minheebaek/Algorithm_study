/* 우선순위 큐 사용
* 문제 정리 링크  : https://www.notion.so/f51aaa445e8a4c3eab16d74b56402c11#47647c6915fa4c7292bbb4cf556470f3
*/
import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;

        for (int i : scoville){
            pq.offer(i);
        }
        int min = pq.peek();
        while (min < k && pq.size() > 1){
            cnt++;
            int num1 = pq.poll();
            int num2 = pq.poll();
            int num3 = num1 + (num2 * 2);
            pq.add(num3);
            min = pq.peek();

        }
        if (min < k){
            return -1;
        }
        return cnt;
    }
}
