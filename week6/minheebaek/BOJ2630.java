import java.io.*;
import java.util.*;

public class Main{
    static int[] cnt;
    static int[][] paper;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        cnt = new int[2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        divide(N,0,0); //색종이 길이, x, y

        for(int i : cnt){
            System.out.println(i);
        }

    }
    public static void divide(int n, int x, int y){
        for(int i=y; i<y+n; i++){
            for(int j=x; j<x+n; j++){
                if(paper[y][x]!=paper[i][j]){
                    divide(n/2,x,y);
                    divide(n/2,x+n/2,y);
                    divide(n/2,x,y+n/2);
                    divide(n/2,x+n/2,y+n/2);

                    return;
                }
            }
        }
        cnt[paper[y][x]]++;
    }
}