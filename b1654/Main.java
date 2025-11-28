package b1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int arr[] = new int[K];

    for (int i = 0; i < K; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    // 길이를 1로 자르면 갯수가 ㅈㄴ많아짐
    // 길이를 N 으로 하면 거의 K 를 못 채울 수 있음
    long maxLen = 0;
    long b = 1;
    long t = Integer.MAX_VALUE;

    while (b <= t) {
      long mid = (t + b) / 2;

      long sum = 0;
      for (int i = 0; i < K; i++) {
        sum += (arr[i] / mid);
      }
      // 갯수가 충족이 안되면?? -> 작은 수로 가야함
      if (sum >= N) {
        maxLen = mid;
        b = mid + 1;
      } else {
        t = mid - 1;
      }
      // 최대 길이보다 짧으면
    }
    System.out.println(maxLen);

  }
}
