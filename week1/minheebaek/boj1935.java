import java.io.*;
import java.util.Stack;

public class Main1{
    static Stack<Double> st = new Stack<Double>();
    public static void main (String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        double[] arr = new double[N];

        for(int i=0; i<arr.length; i++){
            arr[i]=Double.parseDouble(br.readLine());
        }

        double result =postfix(arr, str);
        System.out.printf("%.2f",result);


    }
    static double postfix(double arr[], String str){
        for(int i=0; i<str.length(); i++){
            int idx=-1;
            if('A'<=str.charAt(i)&&str.charAt(i)<='Z'){
                idx=str.charAt(i)-'A';
                st.push(arr[idx]);
            }else{
                double B=st.pop();
                double A=st.pop();
                double value=0;
                switch(str.charAt(i)){
                    case '+':
                        value=A+B;
                        break;
                    case '-':
                        value=A-B;
                        break;
                    case '*':
                        value= A*B;
                        break;
                    case '/':
                        value= A/B;
                        break;

                }
                st.push(value);
            }
        }
        return st.pop();

    }
}