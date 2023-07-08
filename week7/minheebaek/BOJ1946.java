import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] people = new int[N+1];

            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                people[idx]=Integer.parseInt(st.nextToken());
            }

            int vot = people[1];
            int cnt=1;
            for(int j=2; j<=N; j++){
                if(people[j]<vot){
                    vot=people[j];
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}