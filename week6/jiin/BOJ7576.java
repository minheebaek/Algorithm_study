package Algorithm_study.week6.jiin;

import java.io.*;
import java.util.*;
 
public class BOJ7576{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] box ; //토마토 박스
    static Queue<tomato> q = new LinkedList<>();
    static int day = 0;
 
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
 
        m = Integer.parseInt(st.nextToken()); // 박스 가로
        n = Integer.parseInt(st.nextToken()); // 박스 세로 
        box = new int[n][m];

        for(int i = 0 ; i<n; i++){
            String low = br.readLine();
            st = new StringTokenizer(low);
            for(int j = 0; j<m; j++){
                String text = st.nextToken();
                box[i][j] = Integer.parseInt(text); //토마토가 익었다면?
                if(text.equals("1"))
                    q.offer(new tomato(i, j, 0));
            }
        }
        
        bfs();
 
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(box[i][j] == 0)
                    day = -1; // 토마토가 익지 못하는 상황: -1
            }
        }
        if( day != -1 ){
            System.out.println(day - 1);
        }else
            System.out.println(day);
    }
 
    public static void bfs(){
        int[] xside = {1, -1, 0, 0}; //위아래까지
        int[] yside = {0, 0, 1, -1};
 
        while(!q.isEmpty()) {
            tomato tomas = q.poll();
            int tx = tomas.x;
            int ty = tomas.y;
            int days = tomas.day + 1;
            for (int i = 0; i < 4; i++) {
                int ttx = tx + xside[i];
                int tty = ty + yside[i];
                if (ttx >= 0 && ttx < n && tty >= 0 && tty < m){
                    day = days;
                    if (box[ttx][tty] == 0) {
                        q.offer(new tomato(ttx, tty, days)); // 토마토 익음
                        box[ttx][tty] = 1;
                    }
                }
            }
        }
    }
}
 
class tomato{
    int x, y; //가로, 세로
    int day;
 
    tomato(int x, int y, int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }
}