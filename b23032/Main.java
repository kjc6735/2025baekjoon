package b23032;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int arr[] = new int [2000];
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N ; i++){
      arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
    }

    int ans = Integer.MAX_VALUE;
    int answer = 0;

    for(int i =1 ; i <= N; i++){
      int start = i;
      int end = i+1;

      while (start > 0 && end <= N) {
        int L = arr[i] - arr[start-1];
        int R = arr[end] - arr[i];

        if(ans > Math.abs(R - L)){
          ans = Math.min(ans, Math.abs(R - L));
          answer = arr[end] - arr[start-1];
        }else if(ans == Math.abs(R - L)){
          answer = Math.max(answer, arr[end] - arr[start-1]);
        }
        
        if(L >= R) end ++;
        else start--;
      }
    }

    System.out.println(answer);
  }
  
}
