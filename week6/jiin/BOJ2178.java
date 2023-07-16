package Algorithm_study.week6.jiin;

import java.io.*;
import java.util.*;

public class BOJ2178 {
	
	static int[][] maze; //미로 (2차원)
	static int n;
	static int m;
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
    	static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maze = new int[n][m];
		for(int i=0; i<n; i++) { // 티스토리에서 가져옴 ((공백 제거를 하지 않아) string을 쓰지 않아 계속 오류가 났었음)
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}
		
		check = new boolean[n][m];
		check[0][0] = true;
		bfs(0, 0);
		System.out.println(maze[n-1][m-1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int now[] = que.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) { //상하좌우 for문
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
		                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) //미로 이외에 방문하거나 경로가 아닌 경우
                		    continue;
        		        if (check[nextX][nextY] || maze[nextX][nextY] == 0) //이미 방문했거나 미로 길이 아닌 경우
                    		continue;
                    
		                que.add(new int[] {nextX, nextY}); // 이동 좌표 추가
        		        maze[nextX][nextY] = maze[nowX][nowY] + 1; // +1 하는 이유를 몰라 블로그 찾아봄
                        // 한 칸 이동하였기 때문에 이전 출발 지점에서 +1을 해 주는 것
                		check[nextX][nextY] = true;
			}
		}
	}
}