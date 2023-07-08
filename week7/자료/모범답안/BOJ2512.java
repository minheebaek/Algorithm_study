import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        int[] arr =new int[N];

        st=new StringTokenizer(br.readLine()," ");
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            max=max>arr[i]?max:arr[i];
        }
        int M=Integer.parseInt(br.readLine()); // 총 예산

        Arrays.sort(arr);

        int start=0;
        int end=max;

        while(start<=end){
            int mid=(start+end)/2;
            long sum=0;
            for(int budget: arr) {
                if (budget <= mid) {
                    sum += budget;
                } else {
                    sum += mid;
                }
            }
            if(sum>M){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        System.out.println(end);
    }
}