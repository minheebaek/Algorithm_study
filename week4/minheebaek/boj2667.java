import java.util.*;
import java.io.*;

public class Main{
    static int[] dirx={0,0,1,-1};
    static int[] diry={1,-1,0,0};
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new  int[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> list = new ArrayList<>();
        //얼마가 들어올지 모르니까 크기가 가변적으로 변하는 ArrayList 사용

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j]= str.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==1&&!visited[i][j]){
                    count=1; //1부터 시작
                    dfs(i,j);
                    list.add(count); //집개수 저장한거 배열에 넣음
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size()); //배열 사이즈=단지 수
        for(int num : list){
            System.out.println(num); //단지 내 집 개수 출력
        }
    }
    public static void dfs(int x, int y){
        visited[x][y]=true;

        for (int i = 0; i < 4; i++) {
            int nowx = x+dirx[i];
            int nowy = y+diry[i];

            //만약 사방이 0이면 종료되고 count 누적, 단지내 집 개수 저장
            if(nowx>=0&&nowy>=0&&nowx<n&&nowy<n){
                if(map[nowx][nowy]==1&&!visited[nowx][nowy]){
                    dfs(nowx,nowy);
                    count++;
                }
            }

        }
    }
}