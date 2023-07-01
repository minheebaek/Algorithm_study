package Algorithm_study.week5.jiin;

import java.util.Scanner;
public class BOJ10451 {
	static int[] arr; //배열
	static boolean[] visited; //방문 여부
	static int n; //사이클 갯수
	public static int dfs(int i) {
		if(i == arr[i] || visited[i]) return 1;
		visited[i] = true;
		return dfs(arr[i]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(), cnt;
		
		for(int i = 0; i < tc; i++) {
			n = sc.nextInt(); //순열 갯수
            cnt = 0;
			arr = new int[n+1]; //배열 크기 지정
            visited = new boolean[n+1];
			for(int j = 1; j < n+1; j++) //그래프 입력 받기
				arr[j] = sc.nextInt();
			
			for(int j = 1; j < n+1; j++) {
				if(!visited[j]) cnt += dfs(j); //방문하지 않았다면
			}
			System.out.println(cnt);
		}
	}
}
