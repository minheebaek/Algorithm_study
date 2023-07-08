import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int divisionThree;
    static int[][] arr;
    static int[] paperCount = new int[3]; // 종이의 개수, 0번 인덱스: -1, 1번 인덱스: 0, 2번 인덱스: 1

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divisionThree = n;
        recursive(n, 0, 0);
        bw.write(paperCount[0] + "\n");
        bw.write(paperCount[1] + "\n");
        bw.write(paperCount[2] + "\n");

        br.close();
        bw.close();
    }

    static void recursive(int n, int row, int col) throws IOException {
        boolean isPaper = true;
        for(int r = row; r < row + n; r++) {
            for(int c = col; c < col + n; c++){
                if(arr[row][col] != arr[r][c]) {
                    isPaper = false;
                    break;
                }
            }
            if(!isPaper){
                break;
            }
        }
        if(isPaper){
            paperCount[arr[row][col]+1]++;
            return;
        }

        int nextN = n/3;
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                recursive(nextN, row + r * nextN, col + c * nextN);
            }
        }
    }
}