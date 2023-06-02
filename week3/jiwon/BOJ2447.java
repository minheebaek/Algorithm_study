import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] arr;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(bf.readLine());
        arr = new String[N][N];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = " ";
            }
        }
        star(arr, 0, 0, N);

        for (String[] str : arr) {
            for (String s : str) {
                sb.append(s + "");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void star(String[][] arr, int x, int y, int N) {
        if (N == 1) {
            arr[x][y] = "*";
            return; // 종료
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    star(arr, x + i * (N / 3), y + j * (N / 3), N / 3);
                }
            }
        }
    }
}
