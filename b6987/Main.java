package b6987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int arr[][] = new int[6][3];

        for(int i = 0 ; i < 4; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int win = 0;
            int lose = 0;
            int draw = 0;
            int num6 = 0;
            for(int k = 0; k < 18; k++){
                arr[k / 3][k % 3] = Integer.parseInt(st.nextToken());
                if(arr[k/3][k%3] == 6){
                    num6++;
                }
                if(k%3 == 0){
                    win += arr[k/3][k%3];
                }else if(k%3 == 1){
                    draw += arr[k/3][k%3];
                }else {
                    lose += arr[k/3][k%3];
                }
            }
            if(draw % 2 == 1) {
                sb.append(0).append(" ");
                continue;
            }
            if(num6 != 0){
                sb.append(0).append(" ");
                continue;
            }

            if(win + lose + draw != 30){
                sb.append(0).append(" ");
                continue;
            }
            if(win - lose != 0){
                sb.append(0).append(" ");
                continue;
            }

            boolean check = false;
            for(int a= 0 ; a < 6; a++){
                if(arr[a][0] + arr[a][1] + arr[a][2] != 5){
                    check = true;
                    break;
                }
            }
            if(check) {
                sb.append(0).append(" ");
                continue;
            }
            
            Queue<int[]> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            check = false;
            for(int a = 0; a < 6 ; a++) {
                if(arr[a][1] != 0) queue.add(new int[]{a, arr[a][1]});
            }
            while (queue.size() >= 2) {
                int[] tmp1 = queue.poll();
                int[] tmp2 = queue.poll();
                int used = (1 << tmp1[0]) | (1 << tmp2[0]);

                if(set.contains(used)){
                    check = true;
                    break;
                }
                set.add(used);
                if(tmp1[1] - 1 != 0){
                    tmp1[1] -=1;
                    queue.add(tmp1);
                }
                if(tmp2[1] - 1 != 0){
                    tmp2[1] -=1;
                    queue.add(tmp2);
                }
            }
            

            if(queue.size() == 1 || check){
                sb.append(0).append(" ");
                continue;
            }

            sb.append(1).append(" ");
            
        }
        System.out.println(sb.toString());

    }
    
}
