package Algorithm_study.week7.jiin;
import java.io.*;
import java.util.*;


public class BOJ2630 {
	
	static int white = 0;
	static int blue = 0;
	static int[][] paper; // 입력된 색의 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 한 칸
		paper = new int[N][N];
		StringTokenizer st;
        
		for(int i = 0; i < N; i++) { //paper 배열에 입력된 색의 값 넣음
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divied(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void divied(int x, int y, int n) {
		boolean flag = true; // 한 색상으로 되어 있는지?
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(paper[x][y] != paper[x + i][y + j]) { // 한 가지 색이 아니라면
					flag = false; // false
					break;
				}
				if(!flag) break;
			}
		}
		if (flag) { //true (통일)
			if(paper[x][y] == 0) {
				white++;
			}else {
				blue++;
			}
		}else {
            // 주어진 가로, 세로의 길이가 2^N
            // 가로, 세로 각각 2로 나누어서 탐색
            // 나오는 경우의 수가 4가지가 됨
            // 4가지 중에 이해가 안 돼서 블로그 참고ㅠ
			divied(x, y, n / 2);
			divied(x + n / 2, y, n / 2);
			divied(x, y + n / 2, n / 2);
			divied(x + n / 2, y + n / 2, n / 2);
		}
	}
	
}