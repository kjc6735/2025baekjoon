package b1495;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N,M,S, V[] = new int[50];
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer( br.readLine());
    for(int i = 0; i < N ;i++){
      V[i] = Integer.parseInt(st.nextToken());
    }
    int result = findMaxVolume(N, S, M, V);
    System.out.println(result);
  }

  public static int findMaxVolume(int N, int S, int M, int[] volumes) {
    boolean[][] dp = new boolean[N + 1][M + 1];
    dp[0][S] = true;    
    for (int i = 1; i <= N; i++) {
        int volumeChange = volumes[i - 1];
        for (int prevVolume = 0; prevVolume <= M; prevVolume++) {
            if (dp[i - 1][prevVolume]) {
                if (prevVolume + volumeChange <= M) {
                    dp[i][prevVolume + volumeChange] = true;
                }
                if (prevVolume - volumeChange >= 0) {
                    dp[i][prevVolume - volumeChange] = true;
                }
            }
        }
    }
    
    for (int j = M; j >= 0; j--) {
        if (dp[N][j]) {
            return j;
        }
    }
    
    return -1;
  }

}
