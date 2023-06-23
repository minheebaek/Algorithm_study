import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean visited[][];
    static char[][]board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N=Integer.parseInt(br.readLine());
        board=new char[N][N];
        for(int i=0;i<N;i++){
            board[i]=br.readLine().toCharArray();
        }

        visited=new boolean[N][N];
        int answer=0;
        int answer1=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    dfs(i,j,board[i][j]);
                    answer++;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]=='R'){
                    board[i][j]='G';
                }
            }
        }

        visited=new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    dfs(i,j,board[i][j]);
                    answer1++;
                }
            }
        }

        System.out.println(answer+" "+answer1);

    }

    public static void dfs(int x,int y,char c){
        if(x<0||y<0||x>N-1||y>N-1) return;
        if(board[x][y]==c&&!visited[x][y]){
            visited[x][y]=true;
            dfs(x+1,y,c);
            dfs(x,y+1,c);
            dfs(x-1,y,c);
            dfs(x,y-1,c);
        }
    }
}