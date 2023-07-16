package Algorithm_study.week6.jiin;
import java.io.*;
import java.util.*;

public class BOJ5014 {
    static int F, S, G, U, D;
    static int Ans = -1;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        F = Integer.parseInt(st.nextToken()); // 최고
        S = Integer.parseInt(st.nextToken()); // 강호
        G = Integer.parseInt(st.nextToken()); // 가
        U = Integer.parseInt(st.nextToken()); // 위
        D = Integer.parseInt(st.nextToken()); // 아래

        visited = new boolean[F + 1]; // 시작점

        Ans = bfs();

        if(Ans >= 0)
        System.out.println(Ans);
        else System.out.println("use the stairs");
        // up버튼, down버튼을 같이 눌러 최단 경로를 찾아야 함,
        // 이동 불가시 use the stairs 출력 (목적지 도달 불가)
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = true;

        int size = 0;
        int cnt = -1;
        while (!queue.isEmpty()) { // 층, 층 동일 이동 거리에서 방문할 수 있는 층의 개수만! 반복
            size = queue.size();
            cnt++;
            for (int step = 0; step < size; step++) {
                int cur = queue.poll(); //현재 층

                if(cur == G) return cnt; //목적지 도착, 리턴 cnt

                if (cur + U <= F && !visited[cur + U]) {//위로 가봄
                    //이동 위치: 1) 최댓값보다 작고, 아직 방문하지 않아야 함
                    queue.offer(cur + U);
                    visited[cur + U] = true;
                }
                if (cur - D > 0 && !visited[cur - D]) {//아래로 가봄
                    //이동 위치: 1) 최댓값보다 작고, 아직 방문하지 않아야 함
                    queue.offer(cur - D);
                    visited[cur - D] = true;
                }
            }
        }
        return -1;
    }
}