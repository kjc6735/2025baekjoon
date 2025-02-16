package b11561;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());    
        StringBuilder sb = new StringBuilder();    
        for(int tc = 1 ; tc<= test_case; tc++){
            long n = Long.parseLong(br.readLine());
            
            long left = 0;
            long right = (long) Math.sqrt((2*n-1));

            long mid;

            while(left <= right) {
                mid = (left + right) / 2;

                if((mid * (mid + 1)) / 2 <= n){
                    left = mid + 1;
                }else {
                    right = mid-1;
                }
            }

            sb.append(right).append("\n");
        }
        System.out.println(sb.toString());
    }
}
