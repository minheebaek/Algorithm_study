import java.io.*;

public class Main{
    static int[] dirX ={0,0,1,-1};
    static int[] dirY = {1,-1,0,0};
    static int N, nowx,nowy;
    static boolean[][] visited;
    static  char[][] art;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        art = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                art[i][j]=str.charAt(j);
            }
        }

        //정상일때
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


        //비정상일때
        visited = new boolean[N][N]; //배열 초기화
        cnt=0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (art[i][j] == 'G') {
                    art[i][j] = 'R';

                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        int abnormal =cnt;
        System.out.println(normal+" "+abnormal);

    }
    public static void dfs(int x, int y){
        visited[x][y]=true;
        int tmpchar = art[x][y];

        for(int i=0; i<4; i++){ //방문하지 않은 인접노드 찾는 중
            nowx = x+dirX[i];
            nowy = y+dirY[i];

            if(nowx>=0&&nowy>=0&&nowx<N&&nowy<N){
                if(art[nowx][nowy]==tmpchar&&visited[nowx][nowy]==false){
                    visited[nowx][nowy]=true;
                    dfs(nowx,nowy);
                }
            }
        }
    }
}