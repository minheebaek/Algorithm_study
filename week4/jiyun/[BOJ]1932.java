import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	static int[][] arr; // 입력되는 정수 삼각형을 저장할 2차원 배열
	static Integer[][] dp; // 계산한 최댓값을 저장할 2차원 배열 (memoization)
	static int N;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
 
		arr = new int[N][N];
		dp = new Integer[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) { // 정수삼각형 depth
			st = new StringTokenizer(br.readLine(), " ");
 
			for (int j = 0; j < i + 1; j++) { //정수 삼각형 idx
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		for (int i = 0; i < N; i++) { // 가장 마지막 행은 기저값으로, arr와 동일한 값으로 채워준다.
			dp[N - 1][i] = arr[N - 1][i];
		}
 
		System.out.println(find(0, 0));
 
	}
 
	static int find(int depth, int idx) {
		if(depth == N - 1) return dp[depth][idx]; // depth가 마지막 행일 경우에는 바로 값을 반환해준다. (이미 채워져있으므로)
 
		if (dp[depth][idx] == null) { // dp는 마지막 행 외에 다 null 이므로 0,0에서 시작 -> 밑에서 두번째까지 내려감
			// 다음행의 왼쪽,오른쪽값 중의 최댓값 + 해당 자리의 정수 => dp에 최댓값 메모
			dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx]; 
		}
		return dp[depth][idx];
 
	}
}
