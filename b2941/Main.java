package b2941;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
  static Set<String> set = new HashSet<>();
  static{
    set.add("c=");
    set.add("c-");
    set.add("dz=");
    set.add("d-");
    set.add("lj");
    set.add("nj");
    set.add("s=");
    set.add("z=");
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    char[] str = br.readLine().toCharArray();
    int cnt = 0;
    for(int i = 0; i < str.length; i++ ){
      String str2 = String.valueOf(str, i, i + 2 <= str.length ? 2 : 1);
      String str3 = String.valueOf(str, i, i + 3 <= str.length ? 3 : i + 2 <= str.length ? 2 : 1);
      if(set.contains(str3)){
        i += str3.length()-1;
      }
      else if( set.contains(str2)) {
        i += str2.length()-1;
      }
      cnt +=1;
    }

    System.out.println(cnt);
  

  }
}
