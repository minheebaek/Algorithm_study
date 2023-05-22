import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        Queue<Integer>queue=new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());

        int last=0;

        for(int i=0;i<N;i++){
            String []str=br.readLine().split(" ");
            if(str[0].equals("push")){
                last=Integer.parseInt(str[1]);
                queue.add(Integer.parseInt(str[1]));
            }else if(str[0].equals("pop")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.poll());
                }
            }else if(str[0].equals("size")){
                System.out.println(queue.size());
            }else if(str[0].equals("empty")){
                if(queue.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(str[0].equals("front")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.peek());
                }
            }else if(str[0].equals("back")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(last);
                }
            }
        }

    }

}
