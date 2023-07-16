package Algorithm_study.week6.jiin;
import java.io.*;
import java.util.*;
 
public class BOJ1916 {
    static int N,M;
    static ArrayList<Point>[] nodes;
    static int distance[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 도시
        M = Integer.parseInt(br.readLine()); // 버스
        nodes = new ArrayList[N+1];
        distance = new int[N+1];
        for(int i=1; i<=N; i++)
            distance[i] = 987654321;
        for(int i=1; i<=N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발
            int v = Integer.parseInt(st.nextToken()); // 도착
            int value = Integer.parseInt(st.nextToken()); // 가중치
            nodes[u].add(new Point(v, value)); // 0을 처리
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작
        int end = Integer.parseInt(st.nextToken()); // 도착 
        solve(start);
        System.out.println(distance[end]); // 도착까지 최단 거리
    }
    
    public static void solve(int start) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(start, 0)); //시작점과 시작비용 0(원)
        distance[start] = 0; 
        
        while(!pq.isEmpty()) {
            Point po = pq.poll();
            if(distance[po.x] < po.y) // 이미 탐색된 최소비용이 더 작으면 탐색 x
                continue;
            
            for(int i=0; i<nodes[po.x].size(); i++) {
                Point p = nodes[po.x].get(i);
                if(distance[p.x] > distance[po.x] + nodes[po.x].get(i).y) {
                    distance[p.x] = distance[po.x] + nodes[po.x].get(i).y;
                    pq.add(new Point(p.x, distance[p.x]));
                }
            }
        }
        
    }
    
    
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
        // 우선순위큐에서 가까운 값이 우선순위로 계산되게 하는 
        @Override
        public int compareTo(Point o) {
            if(this.y - o.y < 0)
                return 1;
            else
                return 0;
        }
    }
}