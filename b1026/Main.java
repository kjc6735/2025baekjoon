package b1026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a[] = new int[N];
    int b[] = new int[N];
    for(int i =0; i < N ; i++) a[i] = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i =0; i < N ; i++) b[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(b);
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < N ; i++){
      map.put(i, b[i]);
    }
    Arrays.sort(a);
    int result = 0 ;
    for(int i = 0; i < N ; i++){
      result += (a[i] * map.get(N - i -1));
    }
    System.out.println(result);
  } 
}
