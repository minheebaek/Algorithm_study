package Algorithm_study.week7.jiin;
import java.io.*;
import java.util.*;

public class BOJ1992 {	
	public static int[][] image; // 흑백
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
        image = new int[N][N];
		
		for(int i = 0; i < N; i++) { // 배열 입력
			String str = br.readLine();
			
			for(int j = 0; j < N; j++) {
				image[i][j] = str.charAt(j) - '0';
                // '0' 을 쓰지 않아 계속 오류가 났었음
			}
		}
        // x,y, 얼마나? (좁혀 나가야 함)
		QuadTree(0, 0, N);
		System.out.println(sb); // 저장
	}
	
	public static void QuadTree(int x, int y, int size) {
		
		if(isPossible(x, y, size)) {    // 압축 가능하면 압축
			sb.append(image[x][y]);
			return;
		}
		
		int newSize = size / 2;	// 압축 불가능 - 사이즈를 절반으로
		
		sb.append('('); // 재귀 시작 (
		
		QuadTree(x, y, newSize);						// 1
		QuadTree(x, y + newSize, newSize);				// 2
		QuadTree(x + newSize, y, newSize);				// 3
		QuadTree(x + newSize, y + newSize, newSize);	// 4
		
		sb.append(')'); // 재귀 종료 )
		
	}	
	
	// 압축이 가능한지 공간을 확인
	public static boolean isPossible(int x, int y, int size) {
		int val = image[x][y]; // val 배열 맨 처음 값을 저장함 (시작값 저장) 
		for(int i = x; i < x + size; i++) { // x 범위
			for(int j = y; j < y + size; j++) { // y 범위
				if(val != image[i][j]) {
					return false; // i, j 하나라도 숫자가 다르면 for문 나가야 함
				}
			}
		}
		return true;
	}
}