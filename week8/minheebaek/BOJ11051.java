import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N =Integer.parseInt(br.readLine());
            int[] stocks = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                stocks[j] = Integer.parseInt(st.nextToken());
            }

            int max = -1;
            long sum=0;
            for(int k=N-1; k>=0; k--){
                if(stocks[k]>max){
                    max=stocks[k];
                }else{
                    sum+=max-stocks[k];
                }
            }
            System.out.println(sum);
        }
    }
}