package b13707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] arr = new int[5001][5001];
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr[0][0] = 1;

        recur(0);

        System.out.println(arr[N][K]);
    }

    private static void recur(int n) {
        if(n > N) return;

        if(n == 0) {
            for(int j = 1; j <= K; j++) {
                arr[0][j] = (arr[0][j-1]) % 1_000_000_000;
            }
        } else {
            for(int j = 1; j <= K; j++) {
                arr[n][j] = (arr[n][j-1] + arr[n-1][j]) % 1_000_000_000;
            }
        }

        recur(n + 1);
    }
}
