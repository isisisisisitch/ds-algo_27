package ca.bytetube._10_graph;

public abstract class Graph<V, E> {

    protected abstract int verticesSize();

    protected abstract int edgeSize();

    protected abstract void addVertex(V v);

    protected abstract void removeVertex(V v);

    protected abstract void addEdge(V fromV, V toV);

    protected abstract void addEdge(V fromV, V toV, E weight);

    protected abstract void removeEdge(V fromV, V toV);
}
