import java.io.*;
import java.math.BigInteger;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n;
    static BigInteger cnt = new BigInteger("1");
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            cnt=cnt.multiply(new BigInteger("2"));

        }
        cnt=cnt.subtract(new BigInteger("1"));
        System.out.println(cnt);

        if(n<=20){
            hanoi(n,1,3,2);
            System.out.println(sb.toString());
        }
    }
    public static void hanoi(int n, int from, int to, int temp){
        if(n==1){
            sb.append(from+" "+to+"\n");
            return;
        }else{
            hanoi(n-1,from,temp,to);
            sb.append(from+" "+to+"\n");
            hanoi(n-1,temp,to,from);
        }
    }
}