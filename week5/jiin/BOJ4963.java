package Algorithm_study.week5.jiin;
import java.io.*;
import java.util.*;


public class BOJ4963 {
    static String[] strs;
    static int w,h = 0;
    static int[] nX = {-1, 1, 0, 0, -1, -1, 1, 1}; // x 상하좌우 대각선 4개
    static int[] nY = {0, 0, -1, 1, -1, 1, -1, 1}; // y 상하좌우 대각선 4개
    static int[][] graph;
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        strs = br.readLine().split(" ");
        w = Integer.parseInt(strs[0]);
        h = Integer.parseInt(strs[1]);

        while (w != 0 && h != 0) {
            graph = new int[h][w];
            int cnt = 0; // 초기화
            for (int i = 0; i < h; i++) {
                strs = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(strs[j]);
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] != 0) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(cnt + "\n");

            strs = br.readLine().split(" ");
            w = Integer.parseInt(strs[0]);
            h = Integer.parseInt(strs[1]);
        }
        System.out.println(sb.toString());
    }

    static void bfs(int x, int y) { //차례대로 섬의 갯수 세기
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        graph[x][y] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < nX.length; i++) {
                int nextRow = nX[i] + node.x;
                int nextCol = nY[i] + node.y;
                if(nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w) continue;
                if (graph[nextRow][nextCol] == 1) {
                    graph[nextRow][nextCol] = 0;
                    q.offer(new Node(nextRow, nextCol));
                }
            }
        }
    }
}