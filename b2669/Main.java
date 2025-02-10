package b2669;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set  =new HashSet<>();
        for(int i = 0; i < 4 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int maxX = Math.max(x1, x2);
            int maxY = Math.max(y1, y2);
            int minX = Math.min(x1, x2);
            int minY = Math.min(y1, y2);

            for(int x = minX; x < maxX;x++){
                for(int y = minY; y < maxY; y++){
                    set.add(x + " " +y);
                }
            }
        }
        System.out.println(set.size());

    }
    
}
