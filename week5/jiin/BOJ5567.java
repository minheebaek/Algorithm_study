package Algorithm_study.week5.jiin;
import java.io.*;
import java.util.*;

public class BOJ5567 {
    public static int cnt = 0;
    public static boolean[] check;
    public static ArrayList<Integer>[] list;

    public static void Find(int depth, int num){
        if(depth == 2){ //상근이는 친구와 친구의 친구까지만 초대하면 되기 때문에 cnt = 2 인 것까지만 확인
            return;
        }

        for (int i = 0; i < list[num].size(); i++) {
            int next = list[num].get(i);
            check[next] = true;
            Find(depth + 1, next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        check[1] = true;

        Find(0, 1);

        for (int i = 2; i < check.length; i++) {
            if(check[i]){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}