package ca.bytetube._10_graph;

public class Data {
    public static final Object[][] BFS_01 = {
            {"A", "B"}, {"A", "F"},
            {"B", "C"}, {"B", "I"}, {"B", "G"},
            {"C", "I"}, {"C", "D"},
            {"D", "I"}, {"D", "G"}, {"D", "E"}, {"D", "H"},
            {"E", "H"}, {"E", "F"},
            {"F", "G"},
            {"G", "H"},
    };

    public static final Object[][] BFS_02 = {
            {0, 1}, {0, 4},
            {1, 2},
            {2, 0}, {2, 4}, {2, 5},
            {3, 1},
            {4, 6}, {4, 7},
            {5, 3}, {5, 7},
            {6, 2}, {6, 7}
    };

    public static final Object[][] BFS_03 = {
            {0, 2}, {0, 3},
            {1, 2}, {1, 3}, {1, 6},
            {2, 4},
            {3, 7},
            {4, 6},
            {5, 6},
            {6, 7}
    };

    public static final Object[][] BFS_04 = {
            {1, 2}, {1, 3}, {1, 5},
            {2, 0},
            {3, 5},
            {5, 6}, {5, 7},
            {6, 2},
            {7, 6}
    };

    public static final Object[][] DFS_01 = {
            {0, 1},
            {1, 3}, {1, 5}, {1, 6}, {1, 2},
            {2, 4},
            {3, 7}
    };

    public static final Object[][] DFS_02 = {
            {"a", "b"}, {"a", "e"},
            {"b", "e"},
            {"c", "b"},
            {"d", "a"},
            {"e", "c"}, {"e", "f"},
            {"f", "c"}
    };

    public static final Object[][] TOPO = {
            {0, 2},
            {1, 0},
            {2, 5}, {2, 6},
            {3, 1}, {3, 5}, {3, 7},
            {5, 7},
            {6, 4},
            {7, 6}
    };

    public static final Object[][] NO_WEIGHT2 = {
            {0, 3},
            {1, 3}, {1, 6},
            {2, 1},
            {3, 5},
            {6, 2}, {6, 5},
            {4, 7}
    };

    public static final Object[][] NO_WEIGHT3 = {
            {0, 1}, {0, 2},
            {1, 2}, {1, 5},
            {2, 4}, {2, 5},
            {5, 6}, {7, 6},
            {3}
    };

    public static final Object[][] MST_01 = {
            {0, 2, 2}, {0, 4, 7},
            {1, 2, 3}, {1, 5, 1}, {1, 6, 7},
            {2, 4, 4}, {2, 5, 3}, {2, 6, 6},
            {3, 7, 9},
            {4, 6, 8},
            {5, 6, 4}, {5, 7, 5}
    };

    public static final Object[][] MST_02 = {
            {"A", "B", 17}, {"A", "F", 1}, {"A", "E", 16},
            {"B", "C", 6}, {"B", "D", 5}, {"B", "F", 11},
            {"C", "D", 10},
            {"D", "E", 4}, {"D", "F", 14},
            {"E", "F", 33}
    };

    public static final Object[][] WEIGHT3 = {
            {"mtl", "trt", 100}, {"mtl", "van", 200}, {"mtl", "ny", 200},
            {"trt", "van", 50}, {"trt", "LA", 150},
            {"haf", "ottwa", 100}, {"haf", "waterloo", 150},
            {"ottwa", "waterloo", 350}, {"ottawa", "LA", 100},
            {"waterloo", "victoria", 500}, {"waterloo", "LA", 400},
            {"LA", "victoria", 150}
    };

    public static final Object[][] SP = {
            {"A", "B", 10}, {"A", "D", 30}, {"A", "E", 100},
            {"B", "C", 50},
            {"C", "E", 10},
            {"D", "C", 20}, {"D", "E", 60}
    };

    public static final Object[][] BF_SP = {
            {"A", "B", 10}, {"A", "E", 8},
            {"B", "C", 8}, {"B", "E", -5},
            {"D", "C", 2}, {"D", "F", 6},
            {"E", "D", 7}, {"E", "F", 3}
    };

    public static final Object[][] WEIGHT5 = {
            {0, 14, 1}, {0, 4, 8},
            {1, 2, 9},
            {2, 3, 6}, {2, 5, 9},
            {3, 17, 1}, {3, 10, 4},
            {4, 5, 2}, {4, 8, 2},
            {5, 6, 6}, {5, 8, 1}, {5, 9, 4},
            {6, 9, 8},
            {7, 11, 4},
            {8, 9, 1}, {8, 11, 2}, {8, 12, 7},
            {9, 10, 7}, {9, 13, 4},
            {10, 13, 2},
            {11, 12, 7}, {11, 15, 4},
            {12, 13, 2}, {12, 16, 2},
            {13, 16, 7},
            {15, 16, 7}, {15, 17, 7},
            {16, 17, 2}
    };

    public static final Object[][] NEGATIVE_WEIGHT1 = {
            {"A", "B", -1}, {"A", "C", 4},
            {"B", "C", 3}, {"B", "D", 2}, {"B", "E", 2},
            {"D", "B", 1}, {"D", "C", 5},
            {"E", "D", -3}
    };

    /**
     * 有负权环
     */
    public static final Object[][] NEGATIVE_WEIGHT2 = {
            {0, 1, 1},
            {1, 2, 7},
            {1, 0, -2}
    };
}

