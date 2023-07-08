import java.io.*;
import java.util.*;

public class Main{
    static int[] cnt;
    static int[][] paper;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        cnt=new int[3];

        for(int i=0; i<N; i++){ //초기화 작업
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(N,0,0);

        for(int i : cnt){
            System.out.println(i);
        }
    }
    public static void divide(int n, int x, int y){
        for(int i=y; i<y+n; i++){
            for(int j=x; j<x+n; j++){
                if(paper[y][x]!=paper[i][j]){
                    divide(n/3,x,y);
                    divide(n/3,x+n/3,y);
                    divide(n/3,x+2*n/3,y);
                    divide(n/3,x,y+n/3);
                    divide(n/3,x+n/3,y+n/3);
                    divide(n/3,x+2*n/3,y+n/3);
                    divide(n/3,x,y+2*n/3);
                    divide(n/3,x+n/3,y+2*n/3);
                    divide(n/3,x+2*n/3,y+2*n/3);

                    return;
                }
            }
        }
        if(paper[y][x]==-1){
            cnt[0]++;
        }else if(paper[y][x]==0){
            cnt[1]++;
        }else{
            cnt[2]++;
        }
    }
}