package b14916;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    if(n == 1 || n == 3) {
      System.out.println(-1);
      return ;
    }
    
    int cnt = 0;
    int tmp = n;
    cnt += (tmp / 5);
    tmp %= 5;
    cnt += (tmp / 2);
    tmp %= 2;
    
    if(tmp == 0){
      System.out.println(cnt);
      return ;
    }

    cnt = 0;
    tmp = n;
    cnt += (tmp / 5);
    cnt -= 1;
    tmp %= 5;
    tmp += 5;
    cnt += (tmp/ 2);
    tmp %= 2;
    if(tmp == 0){
      System.out.println(cnt);
      return ;
    }
    
    System.out.println(-1);
    




  

    
    
  
  
  }
}
