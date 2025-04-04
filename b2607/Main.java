package b2607;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] str = new String[N];
    int cnt[][] = new int[N]['Z' - 'A' + 1];
    for(int i = 0; i < N; i++){
      str[i] = br.readLine();
      for(int k = 0; k < str[i].length(); k++){
        cnt[i][str[i].charAt(k) - 'A'] +=1;
      }
    }
    int result = 0;
    for(int i = 1; i < N ; i++){
      int tmp = 0;
      int diff = 0;
      int gap = Math.abs(str[0].length() - str[i].length()); 
      if(gap > 1){
        continue;
      }
      for(int k = 0; k < 'Z'-'A'+1;k++){
        tmp += Math.abs(cnt[i][k] - cnt[0][k]);
        if(cnt[i][k] == 0 && cnt[0][k] != 0 || cnt[i][k] != 0 && cnt[0][k] == 0){
          diff++;
        }
      }
      if(diff > 2) continue;
      if(tmp <= 2){
        result ++;
      }
    }
    System.out.println(result);
  }
}
