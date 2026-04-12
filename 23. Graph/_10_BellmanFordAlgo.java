import java.util.ArrayList;
import java.util.Arrays;

public class _10_BellmanFordAlgo{
    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void bellmanFord(ArrayList<Edge> edges,int V,int src){
        int[] dist = new int[V];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 0;i < V;i++)
            for(Edge e:edges)
                if(dist[e.src]+e.wt < dist[e.dest])
                    dist[e.dest] = dist[e.src] + e.wt;
                

        for(Edge e:edges)
            if(dist[e.src]+e.wt < dist[e.dest]){
                System.out.println("Negative cycle detected");
                return;
            }

        for(int d:dist)
            System.out.print(d+" ");
        
        System.out.println();
    }

    public static void main(String[] args){
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0,2 ,4 ));
        edges.add(new Edge(1,2 ,-4 ));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3,4 ,4 ));
        edges.add(new Edge(4,1 ,-1 ));

        bellmanFord(edges, 5, 0);

         ArrayList<Edge> edges2 = new ArrayList<>();
        edges2.add(new Edge(0, 1, 2));
        edges2.add(new Edge(0,2 ,4 ));
        edges2.add(new Edge(1,2 ,-4 ));
        edges2.add(new Edge(2, 3, 2));
        edges2.add(new Edge(3,4 ,4 ));
        edges2.add(new Edge(4,1 ,-11 ));

        bellmanFord(edges2,5 , 0);

    }
}