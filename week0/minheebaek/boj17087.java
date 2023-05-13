import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] distance = new int[n];
        st= new StringTokenizer(br.readLine());

        for(int i=0; i<distance.length; i++){ //배열 초기화
            int num=Integer.parseInt(st.nextToken());
            distance[i]=s-num;
            if(s-num<0){
                distance[i]=-(s-num);
            }
        }
        int result=distance[0];
        if(n==1){ //result
            System.out.println(distance[0]);
        }else{
            for(int i=1;i<distance.length; i++){
                result=GCD(result,distance[i]);
            }
            System.out.println(result);
        }

    }
    //유클리드 호제법을 이용한 최대공약수 구하기
    public static int GCD(int a, int b){
        if(b==0){ //종료조건
            return a;
        }else{ //최대공약수 구하고 다시 호출
            return GCD(b,a%b);

        }
    }
}