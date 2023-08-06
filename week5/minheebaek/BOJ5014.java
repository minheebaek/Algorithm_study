import java.io.*;
import java.util.*;

public class Main{


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        bfs(f,s,g,u,d);

    }
    public static void bfs(int f, int s, int g, int u, int d){
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] visited = new int[f+1];
        queue.add(s); //현재위치 넣기
        visited[s]=1; //방문처리

        while(!queue.isEmpty()){
            int c=queue.poll();//현재층

            if(c==g){
                System.out.println(visited[c]-1);//처음에 +1했으니까 다시 -1
            }
            if(c+u<=f&&visited[c+u]==0){
                visited[c+u]=visited[c]+1;
                queue.add(c+u);
            }
            if(c-d>0&&visited[c-d]==0){
                visited[c-d]=visited[c]+1;
                queue.add(c-d);
            }
        }
        if(visited[g]==0){
            System.out.println("use the stairs");
        }
    }
}