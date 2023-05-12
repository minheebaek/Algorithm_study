import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] num;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        answer=0;
        dfs(0,0);
        if(M==0){
            System.out.println(answer-1);
        }else{
            System.out.println(answer);
        }
    }

    public static void dfs(int start,int sum){
        if(start==N){
            if(sum==M){
                answer++;
            }
            return;
        }
        dfs(start+1,sum+num[start]);
        dfs(start+1,sum);
    }

}
