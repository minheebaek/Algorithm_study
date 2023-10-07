import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        int[] sorted = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++){
            arr[i]=sorted[i]=Integer.parseInt(st.nextToken());

        }
        Arrays.sort(sorted);
        int count=0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<sorted.length; i++){
            if(!hmap.containsKey(sorted[i])){
                hmap.put(sorted[i],count++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            sb.append(hmap.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString());
    }
}