import java.io.*;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>(); //int형 queue선언, linkedlist 이용
        int number=0;
        for(int i=0; i<num; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String str =st.nextToken();

            switch(str){
                case "push":
                    number=Integer.parseInt(st.nextToken());
                    queue.offer(number);
                    break;

                case "pop":
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(queue.poll());
                    }
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    if(queue.isEmpty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;

                case "front":
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(queue.peek());
                    }
                    break;

                case "back":
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(number);
                    }
                    break;
            }
        }

    }
}
