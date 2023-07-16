package Algorithm_study.week6.jiin;

import java.io.*;

public class BOJ10026 {
    static int[] dX ={0,0,1,-1};
    static int[] dY = {1,-1,0,0};
    static int N, nowX,nowY;
    static boolean[][] visited;
    static  char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j]=str.charAt(j);
            }
        }
        //정상
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        int normal = cnt;

        visited = new boolean[N][N];
        cnt=0;
        // 비정상
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') { // 적록색약이면 구분 못하니까 알파벳 바꿈
                    map[i][j] = 'R';

                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){ //방문하지 않았다면 적록색이 아님
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        int abnormal =cnt;
        System.out.println(normal+" "+abnormal);

    }
    public static void dfs(int x, int y){
        //dfs 통하여 인접 행렬을 차례로 순회하여 방문한 것을 체크하고 구역의 갯수 찾음
        visited[x][y]=true;
        int visitedChar = map[x][y];

        for(int i=0; i<4; i++){
            nowX = x+dX[i];
            nowY = y+dY[i];

            if(nowX>=0&&nowY>=0&&nowX<N&&nowY<N){
                if(map[nowX][nowY]==visitedChar&&visited[nowX][nowY]==false){
                    visited[nowX][nowY]=true;
                    // 범위 안 && 방문 안 함 && 이동하려는 좌표의 색상이 같다면 dfs 함수
                    dfs(nowX,nowY);
                }
            }
        }
    }
}