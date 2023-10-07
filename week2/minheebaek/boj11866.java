import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>(); //int형 queue선언
        for(int i=1; i<=N; i++){ //queue에 원소 넣기
            queue.offer(i);
        }
        System.out.print("<");
        while(queue.size()!=1){
            for(int i=0; i<K-1; i++){
                int value=queue.poll();
                queue.offer(value);
            }

            System.out.print(queue.poll() + ", ");


        }

        System.out.print(queue.poll()+">");
    }
}