import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();
        int width = scanner.nextInt();

        int answer = 0;
        if (height == 1) {
            answer = 1;
        } else if (height == 2) {
            answer = Math.min(4, (width+1)/2);
        } else if (height >= 3) {
            if (width >= 7) {
                answer = width-2;
            } else {
                answer = Math.min(4, width);
            }
        }

        System.out.println(answer);
    }
}