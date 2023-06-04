import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());

        int[]num=new int[N];
        int[]dp=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }

        dp[0]=1;
        for(int i=1;i<N;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(num[i]>num[j]&&dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                }
            }
        }
        int answer=0;
        for(int x:dp){
            answer=Math.max(x,answer);
        }
        System.out.println(answer);
    }

}
