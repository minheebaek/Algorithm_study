import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());	// 총 층수
        int S = Integer.parseInt(st.nextToken());	// 현재 강호 층
        int G = Integer.parseInt(st.nextToken());	// 스타트링크 층
        int U = Integer.parseInt(st.nextToken());	// 버튼 업
        int D = Integer.parseInt(st.nextToken());	// 버튼 다운

        if(S == G){
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[F+1];
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        boolean found = false;

        q.add(S);
        visited[S] = true;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int cur = q.remove();

                // 업
                int up = cur+U;
                if(up <= F){
                    if(!visited[up]){
                        q.add(up);
                        visited[up] = true;
                    }
                }
                if(up == G){
                    found = true; break;
                }

                // 다운
                int down = cur-D;
                if(down > 0){
                    if(!visited[down]){
                        q.add(down);
                        visited[down] = true;
                    }
                }
                if(down == G){
                    found = true; break;
                }

            } // End: for

            count++;
            if(found) break;
        } // End: while

        if(found){
            System.out.println(count);
        } else {
            System.out.println("use the stairs");
        }
    }
}