package b25691;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int N, K, state = 0, result = 0;
    static int root = 0;

    static  int list[] = new int[20];
    static int roots[] = new int[20];
    static {
        for(int i = 0; i < list.length; i++){
            list[i] = (1 << i);
            roots[i] = i;
        }
    }
    public static void main(String[] args) throws Exception{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
           
            list[a] |= (1 << b);
            list[b] |= (1 << a);
            roots[b] = a;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N  ;i++){
            if(st.nextToken().equals("1")) state |= (1 << i);
        }
        
        for(int i = 0; i < N; i++){
            if(roots[i] == i){
                root = i;
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1 << root, list[root]}); // 방문처리 / 자식

        while (!queue.isEmpty()) {
            int curr[] = queue.poll();
            int visited = curr[0];
            int childrenArr = curr[1];

            if(Integer.bitCount(visited) == K){
                result = max(result, Integer.bitCount(visited & state));
                continue;
            }

            for(int i = 0; i < N; i++){
                if(((1 << i) & visited) != 0) continue; // 방문한거 넘어가기
                if(((1 << i) & childrenArr) == 0) continue; // 자식이 아니면 넘어가기
                queue.add(new int[]{ visited | (1 << i), childrenArr | list[i]}); // 다음 값..
            }
        }

        System.out.println(result);
    }


    private static int max(int a, int b){
        return a > b ? a : b;
    }
    
}
