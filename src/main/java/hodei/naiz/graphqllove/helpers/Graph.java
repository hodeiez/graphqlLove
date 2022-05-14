package hodei.naiz.graphqllove.helpers;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Hodei Eceiza
 * Date: 5/10/2022
 * Time: 22:35
 * Project: graphqlLove
 * Copyright: MIT
 */
@Getter
public class Graph {
    private int vertices;
    private List<LinkedList<Vertix>> adjacentNodes;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacentNodes = new ArrayList<>();
        IntStream.range(0, vertices).forEach(vertix -> this.adjacentNodes.add(new LinkedList<>()));
    }

    public void addNode(Vertix vertix) {
        this.adjacentNodes.get(vertix.getSource()).addFirst(vertix);
    }
    @Override
    public String toString() {
        StringBuilder resp = new StringBuilder("");
        adjacentNodes.forEach(l -> l.forEach(n -> resp.insert(resp.length(), String.format("node %s is connected to node %s with weight %s\n", n.getSource(), n.getDestination(), n.getWeight()))));
        return resp.toString();
    }
}
