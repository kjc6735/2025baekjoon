package b1699;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int dp[] = new int[N+1];
    for(int i = 1; i <= N ; i++) dp[i] = i;

    for(int i = 2; i <= N; i++){
      int add = i*i;
      for(int k = i; k <= N ; k++){
        if(k % add == 0){
          dp[k] = min(k / add, dp[k]);
        }else {
          dp[k] = min(dp[k], dp[k-1] + 1);
        }
      }
    }
    System.out.println(dp[N]);
  }

  private static int min(int a, int b){
    return a < b ? a : b;
  }
}
