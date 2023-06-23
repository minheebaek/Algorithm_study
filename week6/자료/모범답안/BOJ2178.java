import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] board;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<int[]> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s= st.nextToken();
            for (int j = 0; j < M; j++) {
                board[i][j] =s.charAt(j)-'0';
            }
        }

        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            if (x == N - 1 && y == M - 1) {
                System.out.println(board[x][y]);
                System.exit(0);
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx<0||ny<0||nx>N-1||ny>M-1){
                    continue;
                }
                if (!visited[nx][ny]&&board[nx][ny]==1) {
                    visited[nx][ny]=true;
                    board[nx][ny] = board[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

    }

}
