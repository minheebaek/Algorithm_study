import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        int[] sorted = new int[num];
        HashMap<Integer, Integer> rank = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i]=sorted[i]=Integer.parseInt(st.nextToken());

        }

        Arrays.sort(sorted);
        int ranks=0;
        for(int v : sorted){
            if(!rank.containsKey(v)){
                rank.put(v, ranks);
                ranks++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int key : arr){
            int ranking = rank.get(key);
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);

    }
}