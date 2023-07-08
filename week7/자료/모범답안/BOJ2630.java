import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(whiteSearch(paper, 1, 1, n));
        System.out.println(blueSearch(paper, 1, 1, n));
        return;
    }

    public static int blueSearch(int[][] paper, int x, int y, int size){
        boolean split = false;
        int ans = 0;
        if(size == 0)
            return 0;

        int xBound = x + size - 1;
        int yBound = y + size - 1;
        for(int i = x; i <= xBound; i++){
            for(int j = y; j <= yBound; j++){
                if(paper[i][j] == 0){
                    split = true;
                    break;
                }
            }
            if(split){
                int newSize = size / 2;
                ans += blueSearch(paper, x, y, newSize);
                ans += blueSearch(paper, x + newSize, y, newSize);
                ans += blueSearch(paper, x, y + newSize, newSize);
                ans += blueSearch(paper, x + newSize, y + newSize, newSize);
                return ans;
            }
        }
        return 1;
    }

    public static int whiteSearch(int[][] paper, int x, int y, int size){
        boolean split = false;
        int ans = 0;
        if(size == 0)
            return 0;

        int xBound = x + size - 1;
        int yBound = y + size - 1;
        for(int i = x; i <= xBound; i++){
            for(int j = y; j <= yBound; j++){
                if(paper[i][j] == 1){
                    split = true;
                    break;
                }
            }
            if(split){
                int newSize = size / 2;
                ans += whiteSearch(paper, x, y, newSize);
                ans += whiteSearch(paper, x + newSize, y, newSize);
                ans += whiteSearch(paper, x, y + newSize, newSize);
                ans += whiteSearch(paper, x + newSize, y + newSize, newSize);
                return ans;
            }
        }
        return 1;
    }
}