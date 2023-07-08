import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            String str[] = br.readLine().split(" ");
            int max = 0;
            long sum = 0;
            for(int j=N-1;j>=0;j--){
                int value = Integer.parseInt(str[j]);
                if(value > max){
                    max = value;
                }
                else{
                    sum += (max-value);
                }
            }
            sb.append(sum);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
