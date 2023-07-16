package Algorithm_study.week7.jiin;
import java.io.*;
import java.util.*;

public class BOJ2110 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); // 집
        int C = input.nextInt(); // 공유기
        int[] homeList = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            homeList[i] = input.nextInt();
        }

        Arrays.sort(homeList);

        int max = 0;

        int left = 1; // 최솟값
        int right = homeList[N] - homeList[1]; // 최솟값에서의 최댓값
		// 여기를 틀려서.... 블로그... 참고...,
        int dis = 0;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int start = homeList[1];
            int count = 1;
            for (int i = 1; i <= N; ++i) {
                dis = homeList[i] - start; // 집마다 거리
                if (dis >= mid) { // 공유기가 설치 가능한지 (거리가 기준보다 커야 설치가 가능함)
                    count++;
                    start = homeList[i]; // 설치했다면 이 집부터 다시 체크
                }
            }

            if (count >= C) { // 공유기 설치가 많이 돼서 집마다의 거리??를 넓혀 공유기를 줄여야 함
                ans = mid;
                left = mid + 1; // 집마다의 긴 거리?? 안에서 더 많은 공유기 설치할 수 있는지 여부 확인
            } else {
                right = mid - 1; // 집마다의 짧은 거리?? 안에서 더 적은 공유기 설치할 수 있는지 여부 확인
            }
        }

        System.out.println(ans);
    }
}