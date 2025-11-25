package b1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static class Node {
    int idx;
    int v;

    public Node(int idx, int v) {
      this.idx = idx;
      this.v = v;
    }
  }

  static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    int start = Integer.parseInt(br.readLine());

    for (int i = 0; i <= V; i++) {
      nodes.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      nodes.get(a).add(new Node(b, v));
    }

    boolean[] visited = new boolean[V + 1];
    int dist[] = new int[V + 1];

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    for (int i = 0; i < V; i++) {
      int nodeV = Integer.MAX_VALUE;

      int nodeIdx = 0;

      for (int j = 1; j <= V; j++) {
        if (!visited[j] && dist[j] < nodeV) {
          nodeV = dist[j];
          nodeIdx = j;
        }
      }

      visited[nodeIdx] = true;

      for (int j = 0; j < nodes.get(nodeIdx).size(); j++) {
        Node adjNode = nodes.get(nodeIdx).get(j);

        if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.v) {
          dist[adjNode.idx] = dist[nodeIdx] + adjNode.v;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= V; i++) {
      sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
    }
    System.out.print(sb.toString());

  }

}
