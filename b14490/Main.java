package b14490;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(":");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int min = Math.min(N,M);

        for(int i = min; i > 1; i--){
            if(N % i == 0 && M % i == 0){
                N/=i;
                M/=i;
            }
        }
        System.out.println(N + ":" + M);
    }
}
