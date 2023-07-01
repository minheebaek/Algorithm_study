package Algorithm_study.week5.jiin;

import java.io.*;

public class BOJ1991 {
	
	static class Node{
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
    
	static int n;
	static Node head = new Node('A',null,null);
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 트리 노드의 개수
		for(int i=0;i<n;i++) {
			String [] str = br.readLine().split(" ");
			char root = str[0].charAt(0);
			char left = str[1].charAt(0);
			char right = str[2].charAt(0);
			insertNode(head,root,left,right);
		}
		preNode(head);
		System.out.println();
		inNode(head);
		System.out.println();
		postNode(head);
	}
	static void insertNode(Node tmp, char root,char left, char right) {
		if(tmp.value==root) {
			tmp.left=(left=='.'? null:new Node(left,null,null));
			tmp.right=(right=='.'? null:new Node(right,null,null));
		}
		else { //tmp가 널이 아니라면 노드 탐색
			if(tmp.left != null) insertNode(tmp.left, root, left, right);
			if(tmp.right != null) insertNode(tmp.right, root, left, right);
		}
	}
	static void preNode(Node i) {
		if(i==null)	return;
		System.out.print(i.value);
		preNode(i.left);
		preNode(i.right); // 루 왼 오
	}
	static void inNode(Node i) {
		if(i==null)	return;
		inNode(i.left);
		System.out.print(i.value);
		inNode(i.right); // 왼 루 오
	}
	static void postNode(Node i) {
		if(i==null)	return; // 왼 오 루
		postNode(i.left);
		postNode(i.right);
		System.out.print(i.value);
	} 
}
