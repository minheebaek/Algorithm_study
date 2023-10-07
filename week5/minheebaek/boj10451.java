import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static boolean[] visited;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int num = Integer.parseInt(br.readLine());
            arr = new int[num+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cycle=0;

            for(int j=1; j<num+1; j++){
                arr[j]= Integer.parseInt(st.nextToken());
            }

            visited = new boolean[num+1];
            for(int k =1; k<num+1; k++){
                if(visited[k] != true){
                    dfs(k);
                    cycle++;
                }
            }
            System.out.println(cycle);
        }
    }
    public static void dfs(int number){
        visited[number]=true;

        int nextnum = arr[number];
        if(visited[nextnum]!=true){
            dfs(arr[number]);
        }
    }
}