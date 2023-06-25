import java.io.*;
import java.util.*;

class Tomato{
    int x;
    int y;
    int day;
    Tomato(int x,int y,int day){
        this.x=x;
        this.y=y;
        this.day=day;
    }
}

public class Main {
    static int N;
    static int M;
    static int[][]board;
    static Queue<Tomato>queue;
    static int [][]dir={{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        queue=new LinkedList<>();

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());


        board=new int[M][N];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int a=Integer.parseInt(st.nextToken());
                board[i][j]=a;
                if(a==1){
                    queue.add(new Tomato(i,j,0));
                }
            }
        }
        int answer=0;

        while(!queue.isEmpty()){
            Tomato tomato=queue.poll();
            int x= tomato.x;
            int y= tomato.y;
            int day= tomato.day;
            answer=day;
            for(int i=0;i<4;i++){
                int nx=x+dir[i][0];
                int ny=y+dir[i][1];
                if(nx>=0&&ny>=0&&nx<M&&ny<N&&board[nx][ny]==0){
                    queue.add(new Tomato(nx,ny,day+1));
                    board[nx][ny]=1;
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]==0){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(answer);


    }

}
