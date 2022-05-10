package graph;

//find vertices connected to a source vertex s
public class DepthFirstSearch {

    // is v connected to s?
    private boolean[] marked;
    // how many vertices are connected to s
    private int count;

    public DepthFirstSearch(Graph graph, int source) {
        marked = new boolean[graph.V()];
        dfs(graph, source);
    }

    public void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (Integer w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

}
