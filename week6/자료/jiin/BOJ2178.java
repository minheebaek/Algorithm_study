package Algorithm_study.week6.자료.jiin;
import java.io.*;
import java.util.*;


public class BOJ2178 {
	
	static int[][] maze;
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
		for(int i=0; i<n; i++) {
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
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
		                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                		    continue;
        		        if (check[nextX][nextY] || maze[nextX][nextY] == 0)
                    		continue;
                    
		                que.add(new int[] {nextX, nextY});
        		        maze[nextX][nextY] = maze[nowX][nowY] + 1;
                		check[nextX][nextY] = true;
			}
		}
	}
}