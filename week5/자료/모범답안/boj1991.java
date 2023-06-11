import java.util.*;
import java.io.*;

class Node {
    int left;
    int right;
    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static ArrayList<Node>[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i < N+1; i++) {
            char[] node = br.readLine().replaceAll(" ", "").toCharArray();
            char root = node[0];
            char left = node[1];
            char right = node[2];
            arr[root-'A'+1].add(new Node(left-'A'+1, right-'A'+1));
        }

        sb=new StringBuilder();
        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        System.out.println(sb);

    }

    public static void preorder(int cur) {
        for (Node node : arr[cur]) {
            sb.append((char)(cur+'A'-1));
            if(node.left!=-18) preorder(node.left);
            if(node.right!=-18) preorder(node.right);
        }
    }

    public static void inorder(int cur) {
        for (Node node : arr[cur]) {
            if(node.left!=-18) inorder(node.left);
            sb.append((char)(cur+'A'-1));
            if(node.right!=-18) inorder(node.right);
        }
    }

    public static void postorder(int cur) {
        for (Node node : arr[cur]) {
            if(node.left!=-18) postorder(node.left);
            if(node.right!=-18) postorder(node.right);
            sb.append((char)(cur+'A'-1));
        }
    }

}
