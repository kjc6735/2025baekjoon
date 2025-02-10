package b5046;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

         
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < H ; i++){
            int total = Integer.parseInt(br.readLine()) * N;
            st = new StringTokenizer( br.readLine());
            if(total > B) continue;

            for(int k = 0; k < W ; k++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp < N) continue;
                min = Math.min(min, total);
                break;
            }
        } 

        System.out.println(min == Integer.MAX_VALUE ? "stay home" : min );
        

    }
}
