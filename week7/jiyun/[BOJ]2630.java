//색종이 만들기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ColorPaper {

    public static int white = 0; // 하얀색 색종이의 개수
    public static int blue = 0; // 파란색 색종이의 개수
    public static int[][] board; // 주어지는 전체 종이 상태를 담을 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 전체 종이의 한 변의 길이

        board = new int[N][N]; // 종이 상태 담을 배열을 한 변의 길이로 초기화

        for(int i = 0; i < N; i++) { // 배열 board에 색을 담는다. (하양 = 0 , 파랑 = 1)
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N); //

        System.out.println(white);
        System.out.println(blue);

    }

    public static void divide(int row, int col, int size) {

        if(colorCheck(row, col, size)) { // 전체 종이가 모두 같은 색인지 확인
            if(board[row][col] == 0) { // 전체 종이가 모두 같은 색임이 확인 된 상태이므로 첫 번째 원소만 확인
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        // colorCheck 에서 false( 종이 색상 통일 x) 라면
        int newSize = size / 2;	// 사이즈 분할
        divide(row, col, newSize);						        // 2사분면
        divide(row, col + newSize, newSize);				// 1사분면
        divide(row + newSize, col, newSize);				// 3사분면
        divide(row + newSize, col + newSize, newSize);	// 4사분면
    }

    public static boolean colorCheck(int row, int col, int size) {

        int color = board[row][col];	// 첫 번째 원소를 기준으로 다른 색상 원소 확인
        // 색상이 다르다면 false 반환
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
