import java.util.*;
import java.io.*;

class tomato{ //토마토 객체
    int x;
    int y;

    tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static int[] dirX = {0,0,1,-1};
    static int[] dirY = {1,-1,0,0};
    static Queue<tomato> q = new LinkedList<>();
    static int[][] storage;
    static int N,M;
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        storage = new int[N][M];
        for (int i = 0; i < N; i++) { //배열 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (storage[i][j] == 1) { //익은 토마토라면
                    q.add(new tomato(i, j)); //토마토 객체 생성해서 큐에 넣음
                }
            }
        } //이 코드를 통해 처음 배열에 있는 익은 토마토들을 다 넣음

        System.out.println(bfs());
        //bfs 함수 끝나면 int형 최소일수를 반환할 것임
    }
    public static int bfs(){
        while(!q.isEmpty()){
            tomato t=q.poll(); //큐 반환해서 t와 객체 연결해줌

            int x = t.x;
            int y = t.y;

            for(int i=0; i<4; i++){
                int nowx = x+dirX[i];
                int nowy = y+dirY[i];

                if(nowx>=0&&nowy>=0&&nowx<N&&nowy<M){
                    if(storage[nowx][nowy]==0){//안익은 토마토라면
                        q.add(new tomato(nowx,nowy)); //큐에 넣음
                        storage[nowx][nowy]=storage[x][y]+1; // 일수 증가

                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(storage[i][j]==0){
                    return -1; //안익은 토마토 있으면 -1 반환하고 함수 종료
                }
            }
        }
        int max=-2;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(storage[i][j]>max){
                    max=storage[i][j];
                }
            }
        }
        return max-1;
    }
}
