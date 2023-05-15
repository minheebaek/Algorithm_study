import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st = st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(isPrime(num)) count++;
        }
        System.out.println(count);
    }
    static boolean isPrime(int n) {
        if(n==2) return true;
        else if(n==1 || n==0) return false;
        else {
            for(int i=2; i<n; i++){
                if(n%i == 0) return false;
                else continue;
            }
        }
        return true;
    }
}
