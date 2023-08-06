import java.util.*;

class Solution {
    static ArrayList<Integer> resultArr = new ArrayList<>();
    public int solution(String numbers) {
        char[] temp = numbers.toCharArray();

        int[] arr = new int[temp.length];
        for(int i=0; i<arr.length; i++){
            arr[i]=temp[i]-'0';
        }

        for(int i=1; i<=arr.length; i++){
            permutation(arr,0,arr.length,i);
        }
        return resultArr.size();
    }
    public static void permutation(int[] arr, int depth, int n, int r){
        if(depth==r){
            String str = "";
            for(int j=0; j<r; j++){
                str+=arr[j];
            }

            if(isPrime(Integer.valueOf(str)) && !resultArr.contains(Integer.valueOf(str))){
                resultArr.add(Integer.valueOf(str));
            }
            return;
        }
        for(int j=depth; j<n; j++){
            swap(arr,depth,j);
            permutation(arr,depth+1,n,r);
            swap(arr,depth,j);
        }
    }
    public static void swap(int[] arr,int depth, int j){
        int temp = arr[depth];
        arr[depth]=arr[j];
        arr[j]=temp;
    }
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        int a = (int)Math.sqrt(n);
        for(int j=2; j<=a; j++){
            if(n%j==0){
                return false;
            }
        }
        return true;
    }
}
