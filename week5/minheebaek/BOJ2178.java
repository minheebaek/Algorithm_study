import java.util.*;
import java.io.*;

public class Main{
    static int[] dirX = {0,0,1,-1};
    static int[] dirY = {1,-1,0,0};
    static int N,M;
    static int nowx,nowy;
    static int[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); //행
        M=Integer.parseInt(st.nextToken()); //열
        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j]=str.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(maze[N-1][M-1]);
    }
    public static void bfs(int x, int y){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visited[x][y]=true;

        while(!q.isEmpty()){
            x=q.poll();
            y=q.poll();

            for(int i=0; i<4; i++){ //인접 노드 탐색중
                nowx=x+dirX[i];
                nowy=y+dirY[i];

                if(nowx>=0&&nowy>=0&&nowx<N&&nowy<M){
                    if(maze[nowx][nowy]==1 && visited[nowx][nowy]==false){
                        q.add(nowx); //인접노드 큐에 넣고
                        q.add(nowy);
                        visited[nowx][nowy]=true;
                        maze[nowx][nowy]=maze[x][y]+1;

                        if(visited[N-1][M-1]==true){
                            return;
                        }
                    }
                }
            }
        }
    }
}