import java.util.*;
import java.io.*;

public class Main{
    static int[] dirX ={0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dirY ={1, -1, 0, 0, 1, -1, 1, -1};
    static int[][] island;
    static boolean[][] visited;


    static int nextX,nextY,w,h;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        while(!(str=br.readLine()).equals("0 0")){
            st = new StringTokenizer(str);
            w = Integer.parseInt(st.nextToken());
            h =Integer.parseInt(st.nextToken());
            island = new int[h][w]; //배열생성
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){ //배열 초기화
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cycle = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(island[i][j]==1 && !visited[i][j]){ //섬인데 방문 안했으면
                        dfs(i,j);
                        cycle++;
                    }
                }
            }
            System.out.println(cycle);

        }
    }
    static void dfs(int x, int y){
        visited[x][y]=true;

        for(int i=0; i<8; i++) {
            nextX = dirX[i] + x;
            nextY = dirY[i] + y;

            if (nextX >= 0 && nextY >= 0 && nextX < h && nextY < w) {
                if (island[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}