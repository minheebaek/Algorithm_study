import java.util.*;
import java.io.*;
public class Main{
    static int[] sour;
    static int[] bitter;
    static int N;
    static int res=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        sour = new int[N];
        bitter = new int[N];


        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        cook(0,0,1,0);
        System.out.println(res);
    }
    public static void cook(int input_cnt, int cnt, int sour_mul, int bitter_sum){//넣을 재료 개수, 인덱스
        if(cnt==N){//n번까지 재료를 다 넣었을때
            if(input_cnt!=0){//넣은 재료가 0이 아니라면
                res=Math.min(res, Math.abs(sour_mul-bitter_sum)); //최소값 비교 후 res 저장
            }
            return;
        }
        cook(input_cnt, cnt+1, sour_mul, bitter_sum); //재료를 안 넣었으니까 cnt만 올라가는거
        cook(input_cnt+1, cnt+1, sour_mul*sour[cnt], bitter_sum+bitter[cnt]); //재료를 넣었으니까 곱합
    }
}
