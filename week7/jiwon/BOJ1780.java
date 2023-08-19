import java.util.Scanner;

public class BOJ1780 {
    static int minusOne;
    static int zero;
    static int one;

    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        partition(0, 0, n);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);

    }

    private static void partition(int row, int col, int size) {

        if (ColorCheck(row, col, size)) {
            if (board[row][col] == -1) {
                minusOne++;
            } else if (board[row][col] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        int newSize = size / 3;

        partition(row, col, newSize); // 왼쪽 위
        partition(row, col + newSize, newSize); // 중앙 위
        partition(row, col + 2 * newSize, newSize); // 오른쪽 위

        partition(row + newSize, col, newSize); // 왼쪽 중간
        partition(row + newSize, col + newSize, newSize); // 중앙 중간
        partition(row + newSize, col + 2 * newSize, newSize); // 오른쪽 중간

        partition(row + 2 * newSize, col, newSize); // 왼쪽 아래
        partition(row + 2 * newSize, col + newSize, newSize); // 중앙 아래
        partition(row + 2 * newSize, col + 2 * newSize, newSize); // 오른쪽 아래

    }

    private static boolean ColorCheck(int row, int col, int size) {
        int color = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

}
