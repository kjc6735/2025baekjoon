package b11663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int arr[] = new int[100_000];
  static int N,M;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(arr,0, N);
    
    for(int i =0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int r1 = upperSearch(a);
      
      int r2 = lowerSearch(b);
      

      System.out.println(arr[r2] - arr[r1]);
    }
    
  }

  private static int lowerSearch(int target){
    int startIndex = 0;
    int endIndex = N;
    int midIndex = 0;
    while (startIndex < endIndex) {
      midIndex = (startIndex + endIndex) / 2;
      if(arr[midIndex] <= target){
        startIndex = midIndex+1;
      }else {
        endIndex = midIndex;
      }
    }
    return midIndex -1;
  }

  private static int upperSearch(int target){
    int startIndex = 0;
    int endIndex = N;
    int midIndex = 0;
    while (startIndex < endIndex) {
      midIndex = (startIndex + endIndex) / 2;
      if(arr[midIndex] < target){
        startIndex = midIndex+1;
      }else {
        endIndex = midIndex;
      }
    }
    return midIndex;
  }
  
}
