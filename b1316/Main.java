package b1316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        
        for(int i = 0; i <  N ;i++){
            String str = br.readLine();
            Set<Character> set = new HashSet<>();
            boolean check = true;
            set.add(str.charAt(0));
            for(int k = 1 ;k < str.length(); k++){
                if(str.charAt(k) == str.charAt(k-1)) continue;
                
                if(set.contains(str.charAt(k))) {
                    check = false;
                    break;
                }
                set.add(str.charAt(k));
            }
            if(check) cnt ++;
        }

        System.out.println(cnt);

    }
}
