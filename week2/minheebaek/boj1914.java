import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger res;
        if(n==1) System.out.println(1);
        else {
            for (int i = 0; i < n; ++i) {
                res = res.multiply(new BigInteger("2"));
            }
            res = res.subtract(new BigInteger("1"));
            System.out.println(res);
        }
        if(n<=20) {hanoi(n,1,2,3);

        }

    }
    public static void hanoi(int n, int from, int tmp, int to){
        int count=0;
        if(n==1){
            System.out.println(from+" "+to);
        }else{
            hanoi(n-1, from, to, tmp);
            System.out.println(from+" "+to);
            hanoi(n-1,tmp, from, to);}
    }
}