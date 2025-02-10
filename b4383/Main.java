package b4383;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[3001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            Arrays.fill(arr, 0);
            st = new StringTokenizer(str);
            if(!st.hasMoreElements()) break;
            int N = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for(int i = 0 ; i < N-1 ; i++){
                int tmp = Integer.parseInt(st.nextToken());
                int result = Math.abs(prev - tmp);
                arr[result] = 1;
                prev = tmp;
            }
            if(check(N)){
                sb.append("Jolly\n");
            }else {
                sb.append("Not jolly\n");
            }
        }

        System.out.println(sb.toString());

    }

    private static boolean check(int n){
        for(int i = 1; i < n; i++){
            if(arr[i] == 0) return false;
        }
        return true;
    }
}
