import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 우선 순위 낮은 순
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
			    pq.add(scoville[i]);
	  	  }
        
        while (pq.peek() < K) {
            if(pq.size() == 1) return -1;
            int a = pq.poll();
            int b = pq.poll();
            int c = a + (b * 2);
            pq.add(c);
            answer++;
        }
        
        return answer;
    }
}
