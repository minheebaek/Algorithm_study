import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville){
            pq.offer(n);
        }

        while(pq.peek()<K){
            if(pq.size()==1){
                return -1;
            }

            pq.offer(pq.poll()+(pq.poll()*2));
            answer++;
        }

        return answer;
    }
}