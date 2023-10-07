import java.io.*;
import java.util.*;

public class Main{
    public static int ans=0;
    public static ArrayList<Integer>[] list;
    public static int[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];//동기 배열 만들고
        visited = new int[n+1];//방문도 만들어야함
        //배열 안에 또 ArrayList
        for(int i=1; i<n+1; i++){
            list[i]=new ArrayList<>();
        }

        //양방향 그래프 설정
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);

        }
        bfs();
        System.out.println(ans);

    }
    public static void bfs(){
        //bfs 사용을 위한 큐 선언 LinkedList 사용
        Queue<Integer> queue = new LinkedList<>();
        //처음 원소 큐에 넣음
        queue.add(1);
        visited[1]++; //방문처리

        while(!queue.isEmpty()){ //큐가 다 비워질때까지 반복
            int v=queue.poll(); //큐 뽑아냄
            if(visited[v]>=3){ //3이상이면 친구의 친구까지 다 돌았다는거니까
                break;
            }
            for(int next : list[v]){ //그게 아니라면 뽑은 원소를 기준으로
                //인접노드들을 하나씩 확인함
                if(visited[next]==0){
                    //아직 방문하지 않았다면
                    visited[next]=visited[v]+1;
                    //방문처리하고
                    queue.add(next);
                    ans++;
                }

            }
        }

    }
}