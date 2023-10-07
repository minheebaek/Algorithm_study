import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] triangle = new int[num][num];
        //배열 초기화
        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i; j++){
                triangle[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //가장자리 합
        for(int i=1; i<num; i++){
            triangle[i][0]+=triangle[i-1][0];
            triangle[i][i]+=triangle[i-1][i-1];
        }
        //둘 중 하나 선택해서 최대합
        for(int i=2; i<num; i++){
            for(int j=1; j<i; j++ ){
                triangle[i][j]+=Math.max(triangle[i-1][j-1],triangle[i-1][j]);

            }
        }
        Arrays.sort(triangle[num-1]);
        System.out.println(triangle[num-1][num-1]);
    }
}