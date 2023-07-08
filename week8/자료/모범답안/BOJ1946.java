import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * pro_190426
 *
 * 그리디알고리즘
 *
 *
 * https://www.acmicpc.net/problem/1946
 *
 * 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지
 *  않는 자만 선발한다는 원칙을 세웠다. 즉, 어떤 지원자 A의 성적이 다른 어떤
 *  지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는
 *  결코 선발되지 않는다.
 *
 * 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성
 *
 *  지원자의 숫자 N(1 ≤ N ≤ 100,000)
 * 성적1 성적2
 *
 * 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader( new InputStreamReader( System.in ) );
        StringTokenizer st = new StringTokenizer( bf.readLine() );

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer( bf.readLine() );
            int N  = Integer.parseInt( st.nextToken() );

            int S[] = new int[N+1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer( bf.readLine() );
                //SCORE1 을 기준으로 정렬한다.
                S[ Integer.parseInt(st.nextToken()) ] = Integer.parseInt(st.nextToken());
            }

            int rslt = 1;
            //SCORE2 를 비교한다
            int preScore = S[1];
            for  (int i = 2; i <= N; i++) {
                if( S[i] < preScore ){
                    rslt++;
                    preScore = S[i];
                }
            }

            System.out.println(rslt);
        }


    }
}