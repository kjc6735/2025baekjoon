package b25691;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
    Integer parent = null;
    List<Integer> children = new ArrayList<>();


    public void setParent(int parent){
        this.parent = parent;
    }
    public void addChild(int child){
        children.add(child);
    }
}

public class Main {
    static int N, K, state = 0, result = 0;
    static int root = 0;

    static  List<Integer>list[] = new ArrayList[20];
    static int roots[] = new int[20];
    static {
        for(int i = 0; i < list.length; i++){
            list[i] = new ArrayList();
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
            list[a].add(b);
            list[b].add(a);
            roots[b] = a;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N  ;i++){
            if(st.nextToken().equals("1")) state |= (1 << i);
        }

        root = -1;

        for(int i = 0; i < N  ;i++){
           if(roots[i] != i) continue;
            root = (1 << i);
            break;
        }
        for(int i = 0 ; i < N; i++){
            find(i, 1, 1 << i);
        }
        System.out.println(result);
    }

    private static void find(int curr, int cnt, int visitied){
        if(cnt == K){
            if((visitied & root) == 0) return ; 
            int r = Integer.bitCount( visitied & state );
            result = max(result,r);
            return; 
        }
       
        for(int next : list[curr]){
            if( ( visitied & ( 1 << next)) != 0) continue;
            find(next, cnt + 1, visitied | ( 1 << next));
        }
    }

    private static int max(int a, int b){
        return a > b ? a : b;
    }

}
