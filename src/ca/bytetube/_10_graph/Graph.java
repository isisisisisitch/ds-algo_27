package ca.bytetube._10_graph;

import java.util.List;

public abstract class Graph<V, E> {

    protected abstract int verticesSize();

    protected abstract int edgeSize();

    protected abstract void addVertex(V v);

    protected abstract void removeVertex(V v);

    protected abstract void addEdge(V fromV, V toV);

    protected abstract void addEdge(V fromV, V toV, E weight);

    protected abstract void removeEdge(V fromV, V toV);

    public abstract void bfs(V begin);

    public abstract void bfs(V begin, VertexVisitor<V> visitor);

    public abstract void dfs(V begin);

    public abstract void dfs(V begin, VertexVisitor<V> visitor);

    public abstract List<V> topologicalSort(V begin);

    public abstract static class VertexVisitor<V> {
        public abstract boolean visit(V val);
    }
}
