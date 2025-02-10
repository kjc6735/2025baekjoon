package b1092;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());
        
        if(boxes.get(0) > cranes[0]) {
            System.out.println(-1);
            return;
        }
        
        int time = 0;
        while(!boxes.isEmpty()) {
            int boxIndex = 0;
            for(int craneIndex = 0; craneIndex < N;) {
                if(boxIndex >= boxes.size()) break;
                
                if(cranes[craneIndex] >= boxes.get(boxIndex)) {
                    boxes.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }
            time++;
        }
        
        System.out.println(time);
    }
}