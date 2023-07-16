package Algorithm_study.week7.jiin;
import java.io.*;
import java.util.*;

public class BOJ2512 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 지방
		
		int left = 0; // 최소 예산
		int right = -1; // 예산 최대 금액
		int[] arr = new int[n]; // 지방 예산
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
        
		int m = Integer.parseInt(br.readLine());
		while(left<=right) {
			int mid = (left+right)/2;
			long budget = 0; //상한액으로 얻을 수 있는 예산
			for(int i=0; i<n; i++) {
				if(arr[i]>mid) budget += mid;
				else budget+= arr[i];
			}
			if(budget<=m) { // 예산이 총량에 도달하지 못함
				left = mid+1; // 더 최고의 경우의 수를 구하기 위해 +1
			}else { // 예산 초과
				right = mid-1; // 세금 줄여야 함
			}
		}
		System.out.println(right);
	}
}