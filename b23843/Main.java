package b23843;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long arr[] = new long[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      arr[i] = Long.parseLong(st.nextToken());

    long max = 0;

    long tmp[] = new long[M];

    Arrays.sort(arr);
    for (int i = N - 1; i >= 0; i--) {
      tmp[0] += arr[i];
      Arrays.sort(tmp);
      System.out.println(Arrays.toString(tmp));
    }

    for (int i = 0; i < M; i++) {
      max = Math.max(tmp[i], max);
    }

    System.out.println(max);
  }

}
