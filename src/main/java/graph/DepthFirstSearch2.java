package graph;

import java.util.Stack;

/**
 * DFS marks all the vertices connected to a given source in time proportional to the sum of their degrees.
 * <p>
 * <p>
 * Connectivity. Given a graph, support queries of the form Are two given vertices
 * connected ? and How many connected components does the graph have ?
 * <p>
 * Single-source paths. Given a graph and a source vertex s, support queries of the
 * form Is there a path from s to a given target vertex v? If so, find such a path.
 */
public class DepthFirstSearch2 {

    /**
     * It maintains an array of boolean values
     * to mark all of the vertices that are
     * connected to the source
     */
    boolean[] marked;
    int count;

    public DepthFirstSearch2(Graph graph, int v) {
        this.marked = new boolean[graph.V()];
        dfs(graph, v);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}

class FindPath {
    boolean marked[];
    int edgeTo[];
    int s;

    public FindPath(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;

        dfs(G, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (Integer w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }

    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

}
