package b2161;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N ; i++) queue.add(i);
        boolean toggle = true;
        while (queue.size() != 1) {
            if(toggle){
                sb.append(queue.poll()).append(" ");
            }else{
                queue.add(queue.poll());
            }
            toggle = !toggle;
        }
        System.out.println(sb.toString() + queue.peek());
    }
}
