package b6236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int arr[] = new int[N];

    int start = 0;
    int end = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      start = Math.max(start, arr[i]);
      end += arr[i];
    }
    int mid = 0;
    while (start <= end) {
      mid = (start + end) / 2;
      int charge = mid;
      int count = 1;
      for (int money : arr) {
        if (charge - money < 0) {
          count += 1;
          charge = mid;
        }
        charge -= money;
      }
      if (count > M)
        start = mid + 1;
      else
        end = mid - 1;
    }

    System.out.println(mid);

  }

}
