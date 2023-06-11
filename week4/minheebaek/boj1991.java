import java.io.*;

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}

class TreeOrderClass {
    public Node root;

    public void createNode(char data, char leftData, char rightData) {
        if(root == null) {
            root = new Node(data);

            if(leftData != '.') {
                root.left = new Node(leftData);
            }
            if(rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }


    public void searchNode(Node root, char data, char leftData, char rightData) {
        if(root == null) {
            return;
        } else if(root.data == data) {
            if(leftData != '.') {
                root.left = new Node(leftData);
            }
            if(rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root.left, data, leftData, rightData);
            searchNode(root.right, data, leftData, rightData);
        }
    }


    public void preorder(Node root){
        System.out.print(root.data);
        if(root.left!=null) preorder(root.left);
        if(root.right!=null) preorder(root.right);
    }

    public void inorder(Node root){
        if(root.left!=null) inorder(root.left);
        System.out.print(root.data);
        if(root.right!=null) inorder(root.right);
    }


    public void postorder(Node root){
        if(root.left!=null) postorder(root.left);
        if(root.right!=null) postorder(root.right);
        System.out.print(root.data);
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeOrderClass t = new TreeOrderClass();

        for(int i = 0; i < N; i++) {
            char[] data;
            data = br.readLine().replaceAll(" ", "").toCharArray();
            t.createNode(data[0], data[1], data[2]);
        }


        t.preorder(t.root);
        System.out.println();

        t.inorder(t.root);
        System.out.println();

        t.postorder(t.root);

        br.close();
    }

}