import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        ArrayList<Integer>[]arr=new ArrayList[N+1];

        for(int i=0;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        Queue<Integer>queue=new LinkedList<>();
        queue.add(1);

        boolean[]visited=new boolean[N+1];
        int[]check=new int[N+1];

        while(!queue.isEmpty()){
            int now=queue.poll();
            for(int x:arr[now]){
                if(!visited[x]){
                    visited[x]=true;
                    check[x]=check[now]+1;
                    queue.add(x);
                }
            }
        }
        int answer=0;
        for(int i=2;i<N+1;i++){
            if(check[i]<3&&check[i]>0) answer++;
        }
        System.out.println(answer);
    }
}