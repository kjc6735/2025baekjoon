package b13702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    long max = 0;
    long min = 1;

    for(int i =0 ; i < N ; i++) {

      arr[i] = Integer.parseInt(br.readLine());
      if(max  < arr[i]) max = arr[i];
    }

    while (min <= max) {
      long mid = (min + max) / 2;
      int cnt = 0;
      for(int i = 0; i < N; i++){
        cnt += (arr[i] / mid); // 초ㅇ 갯ㅜ
      }

      if(cnt >= K){
        min = mid + 1;
      }else {
        max = mid - 1;
      }
    }
    System.out.println(max);
  
  }
}
