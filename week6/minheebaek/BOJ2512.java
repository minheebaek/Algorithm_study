import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] money = new int[N];
        for(int i=0; i<N; i++){
            money[i] = Integer.parseInt(st.nextToken());

        }
        int m =Integer.parseInt(br.readLine());
        Arrays.sort(money);

        int max=money[N-1];
        int min=1;

        while(min<=max){ //이분탐색 시작
            int mid=(min+max)/2;
            int sum=0;
            for(int i=0; i<N; i++){
                if(mid>money[i]){ //상한액보다 예산이 더 작으면 예산을 줌
                    sum+=money[i];
                }else{ //상한액보다 예산이 더 크면 상한액만큼 줌
                    sum+=mid;
                }
            }

            if(sum>m){//합이 총액보다 커->상한액을 낮춰야함
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        System.out.println(max);
    }
}