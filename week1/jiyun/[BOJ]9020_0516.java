import java.io.*;

public class Main{
    public static boolean[] prime = new boolean[10001];  // 소수x : true
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        isPrime(); //
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int n = Integer.parseInt(br.readLine());
            int p = n/2;
            int q = n/2;

            while(true){
                if(!prime[p] && !prime[q]){
                    sb.append(p).append(" ").append(q).append('\n');
                    break;
                }
                p--;
                q++;
            }
        }
        System.out.println(sb);
    }
    static void isPrime() {
        prime[0] = prime[1] = true;
 
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) { // 범위... 조심 
				prime[j] = true;
			}
		}
    }
}
