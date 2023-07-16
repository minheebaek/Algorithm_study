package Algorithm_study.week5.jiin;

import java.util.*;
import java.io.*;

public class al7 { //시간복잡도
  public static void main(String[] args) {
    BinarySearch T = new BinarySearch();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
    System.out.println(T.solution(n, m, arr));
  }
  public int solution(int n, int m, int[] arr) {
    int answer = 0;
    int left = 0, right = n - 1;
    Arrays.sort(arr);

    while (true) {
      int mid = (left + right) / 2;
      if (arr[mid] == m) { 
        answer = mid + 1;
        break;
      } else if (arr[mid] > m) right = mid;
      else left = mid + 1;
    }
    return answer;
  }
}