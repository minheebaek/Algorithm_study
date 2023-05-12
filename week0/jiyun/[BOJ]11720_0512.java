import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 숫자의 개수가 주어진다.
        char[] arr = (br.readLine()).toCharArray();  // N개의 숫자가 한 줄에 공백이나 구분자없이 주어진다.
        int ans = 0;

        for(int i=0; i<N; i++){
            ans += Integer.parseInt(String.valueOf(arr[i]));
        }
        System.out.println(ans);

    }
}
