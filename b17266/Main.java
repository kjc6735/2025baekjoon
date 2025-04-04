package b17266;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int arr[] = new int[M];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int dist = arr[0] = Integer.parseInt(st.nextToken());
    int dist2 = 0;

    for(int i = 1; i < M ; i++){
      int tmp = Integer.parseInt(st.nextToken());
      arr[i] = tmp;
      if(arr[i] - arr[i-1] > dist2){
        dist2 = arr[i] - arr[i-1];
      }
    }
    dist2 = dist2 % 2 == 0 ? dist2 / 2 : (dist2 / 2)+1;
    int dist3 = N - arr[M-1];
    int result = max(dist ,dist2);
    result = max(result, dist3);
    System.out.println(result);
  }
  
  private static int max(int a , int b){
    return a < b ? b : a;
  }
}
