package b16953;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{A, 1L});
        
        while (!queue.isEmpty()) {
            long curr[] = queue.poll();
            if(curr[0] == B){
                System.out.println(curr[1]);
                return ;
            }


            long calc1 = curr[0] * 2;
            long calc2 = curr[0] * 10 + 1;
            if(calc1 <= B) queue.add(new long[]{calc1, curr[1] + 1});
            if(calc2 <= B) queue.add(new long[]{calc2, curr[1] + 1});
        }
        System.out.println(-1);
    }
}
