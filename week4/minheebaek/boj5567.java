import java.util.*;
import java.io.*;

public class Main{
    public static ArrayList<Integer>[] list;
    public static int[] visited;
    public static int cnt=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        visited = new int[n+1];

        for(int i=1; i<= n; i++){
            list[i]=new ArrayList<Integer>();

        }
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        bfs();
        System.out.println(cnt);
    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]++;

        while(!q.isEmpty()){
            int v = q.poll();

            if(visited[v] >=3){
                break;
            }
            for(int next : list[v]){
                if(visited[next]==0){
                    visited[next]=visited[v]+1;
                    q.add(next);
                    cnt++;
                }
            }
        }
    }
}