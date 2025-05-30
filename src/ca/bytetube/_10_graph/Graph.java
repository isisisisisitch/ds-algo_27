package ca.bytetube._10_graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Graph<V, E> {

    protected WeightManager<E> weightManager;

    public Graph(WeightManager<E> weightManager) {
        this.weightManager = weightManager;
    }

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

    public abstract List<V> topologicalSort();

    public abstract Set<EdgeInfo<V, E>> mst();

    public abstract Map<V, E> shortestPathWithOutPathInfo(V begin);

    public abstract Map<V, PathInfo<V, E>> shortestPath(V begin);

    public abstract Map<V, Map<V, PathInfo<V, E>>> shortestPath();

    public abstract static class VertexVisitor<V> {
        public abstract boolean visit(V val);
    }

    public static class PathInfo<V, E> {
        protected E weight;
        protected List<EdgeInfo<V, E>> edgeInfos = new LinkedList<>();

        public PathInfo() {
        }

        public PathInfo(E weight) {
            this.weight = weight;
        }

        public E getWeight() {
            return weight;
        }

        public void setWeight(E weight) {
            this.weight = weight;
        }

        public List<EdgeInfo<V, E>> getEdgeInfos() {
            return edgeInfos;
        }

        public void setEdgeInfos(List<EdgeInfo<V, E>> edgeInfos) {
            this.edgeInfos = edgeInfos;
        }

        @Override
        public String toString() {
            return "PathInfo{" +
                    "weight=" + weight +
                    ", edgeInfos=" + edgeInfos +
                    '}';
        }
    }


    public static class EdgeInfo<V, E> {
        E weight;
        V from;
        V to;

        public EdgeInfo(E weight, V from, V to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        public E getWeight() {
            return weight;
        }

        public void setWeight(E weight) {
            this.weight = weight;
        }

        public V getFrom() {
            return from;
        }

        public void setFrom(V from) {
            this.from = from;
        }

        public V getTo() {
            return to;
        }

        public void setTo(V to) {
            this.to = to;
        }

        @Override
        public String toString() {
            return

                    "{from=" + from +
                            ", to=" + to +
                            ",weight=" + weight +
                            '}';
        }
    }

    public interface WeightManager<E> {
        int compare(E w1, E w2);

        E add(E w1, E w2);

        E zero();
    }
}
