import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                int A = Math.abs(a);
                int B = Math.abs(b);

                if(A==B){
                    if(a>b) return 1; //바꿈
                    else return -1; //안바꿈
                }else{
                    return A-B; //양수면 바꾸고 음수면 안바꿈
                }

            }
        });

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.offer(num);
            }

        }
    }
}