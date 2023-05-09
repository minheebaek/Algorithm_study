import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter를 사용하면 시간이 더 줄어든다. 144ms -> 124ms (java 11 기준)
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            // .append의 새로운 작성법을 배움
            sb.append("Case #")
                .append(i)
                .append(": ")
                .append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) )
                .append('\n');
        }
        System.out.println(sb);
        // bw.write(sb.toString());
        // bw.flush();

    }
}
