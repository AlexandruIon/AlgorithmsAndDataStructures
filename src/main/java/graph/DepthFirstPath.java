package graph;

import java.util.Stack;

public class DepthFirstPath {

    private boolean[] marked;
    private int edgeTo[];
    private final int source;

    public DepthFirstPath(Graph graph, int source) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.source = source;

        dfs(graph, source);
    }

    public void dfs(Graph graph, int v) {
        marked[v] = true;

        for (Integer w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, v);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x])
            path.push(x);
        path.push(source);
        return path;
    }
}
