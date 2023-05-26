/* 우선순위가 높은 프로세스부터 출력하는 문제로 우선순위 큐를 사용해서 푼다.
* 1) 우선순위가 높은 프로세스 먼저 출력
* 2) location에 담긴 인덱스의 프로세스가 몇 번째로 출력되는지 반환.
* 
* 우선순위가 담긴 priorities를 우선순위큐에도 최대 힙(내림차순)으로 담아서
* priorities와 비교해서 우선순위가 높은 프로세스를 먼저 출력하고,
* 반복되는 횟수를 answer에 담아 location에 해당하는 프로세스가 몇번 째로 출력되는지 확인한다.
*/

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최대 힙 우선순위 큐 호출
        
        for (int i=0; i < priorities.length; i++){ 
            pq.add(priorities[i]);                  //우선순위가 담긴 배열을 최대 힙 우선순위 큐에 담는다. => pq의 루트노드는 가장 높은 우선순위
        }
        
        while(!pq.isEmpty()){  //우선순위 큐가 빌 때까지 반복
            for (int i = 0; i < priorities.length; i++){  //현재 출력하려는 프로세스가 가장 높은 우선순위가 맞는지 확인하는 과정
                if(priorities[i] == pq.peek()){  //현재 출력하려는 프로세스의 우선순위가 pq의 루트노드인지 확인하고 맞다면
                    if (i == location){  // 실행 순번을 알고싶어하는 프로세스의 인덱스인지 확인하고 맞다면
                        answer++;         // 실행 순서 증가
                        return answer;  
                    }
                    pq.poll();  // 인덱스 불일치한다면 pq에서 삭제(= 프로세스 실행)
                    answer++;   // 실행 순서 증가
                }
            }
        }        
        return answer;
    }
}
