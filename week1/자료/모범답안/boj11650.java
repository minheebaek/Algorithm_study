import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        N=Integer.parseInt(br.readLine());

        int num[][]=new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            num[i][0]=Integer.parseInt(st.nextToken());
            num[i][1]=Integer.parseInt(st.nextToken());
        }


        Arrays.sort(num, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for(int i=0;i<N;i++){
            sb.append(num[i][0]+" "+num[i][1]+"\n");
        }
        System.out.println(sb);
    }

}
