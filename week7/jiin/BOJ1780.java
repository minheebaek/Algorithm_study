package Algorithm_study.week7.jiin;
import java.io.*;
import java.util.*;


public class BOJ1780 {
	private static int n; //색종이의 크기
    private static int map[][];
    private static int[] cnt = new int[3];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n);
        
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }

    private static boolean check(int row, int col, int n) { // 모두 같은 수로 되어 있는지 체크하는 함수 
        int num = map[row][col]; // 행과 열을 파라미터로 받아 이중 for문으로 체크해서 모두 같은 수면 true, 아니면 false를 반환
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (num != map[i][j])
                    return false;
            }
        }
        return true;
    }

    private static void divide(int row, int col, int n) {
         //만약 종이가 모두 같은 수로 되어 있다면, 이 종이를 그대로 사용한다. -> return
        if (check(row, col, n)) { //모든 원소는 0이거나 1일 때만 빠져나옴
            cnt[map[row][col]+1]++;  // = cnt 값 증가
        } else { // 0,1이 아닌 경우엔 3으로 나눈 후 과정을 반복 
            int s = n / 3; // 3으로 나누는 건 어차피 n이 3의 제곱수이기 때문임
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(row + s * i, col + s * j, s);
                }
            }
        }
    }
}