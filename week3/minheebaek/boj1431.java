import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i]=br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length()==s2.length()){
                    if(add(s1)==add(s2)){
                        return s1.compareTo(s2);
                    }else return Integer.compare(add(s1),add(s2));

                }else return s1.length()-s2.length();
            }
        });

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static int add(String s){
        int sum=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                sum+=s.charAt(i)-'0';
            }
        }
        return sum;
    }
}