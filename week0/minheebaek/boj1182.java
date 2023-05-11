import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[] arr;
    static int n,s, count=0;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }
        dfs(0,0);

        if(s==0){
            System.out.println(count-1);
        }else{
            System.out.println(count);
        }
    }
    public static void dfs(int dep, int sum){
        //종료조건
        if(dep==n) {
            if(sum == s) {
                count++;
            }
            return;
        }
        //재귀함수
        dfs(dep+1, sum+arr[dep]);
        dfs(dep+1, sum);
    }
}
