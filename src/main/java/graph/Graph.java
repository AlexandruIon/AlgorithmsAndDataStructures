package graph;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Graph {

    // number of vertices
    private final int V;
    //number of edges
    private int E;
    //adjacency list
    private List<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        this.E = v;
        adj = (List<Integer>[]) new List[v];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public Graph(InputStream inputStream) throws IOException {
        this(inputStream.read());
        int E = inputStream.read();
        for (int i = 0; i < E; i++) {
            // add an ege
            int v = inputStream.read();
            int w = inputStream.read();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V(){return V;}
    public int E(){return E;}

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
