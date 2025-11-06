package b13904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args)throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int arr[] = new int[1001];

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] != a[1] ? b[1] - a[1] : b[0] != a[1] ? a[0] - b[0] : b[0] - a[0]);
    for(int i =0; i < N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      pq.add(new int[]{a,b});
    }


    int result = 0;
    while (!pq.isEmpty()) {
      int curr[] = pq.poll();
      int index = curr[0];
      int value = curr[1];
      for(int i = index; i > 0; i--){
        if(arr[i] != 0) continue;
        arr[i] = value;
        result+= value;
        break;
      }
    }
    System.out.println(result);

  }
}
