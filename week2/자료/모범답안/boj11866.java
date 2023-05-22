import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        Deque<Integer>deque=new LinkedList<>();
        for(int i=1;i<=N;i++){
            deque.add(i);
        }
        sb.append("<");

        while(!deque.isEmpty()){
            if(deque.size()==1){
                sb.append(deque.poll()+">");
                break;
            }
            for(int i=1;i<K;i++){
                int x=deque.poll();
                deque.addLast(x);
            }
            sb.append(deque.poll()+", ");
        }
        System.out.println(sb);
    }
}
