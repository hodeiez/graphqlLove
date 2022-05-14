package hodei.naiz.graphqllove.helpers;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Created by Hodei Eceiza
 * Date: 5/10/2022
 * Time: 23:29
 * Project: graphqlLove
 * Copyright: MIT
 */
@AllArgsConstructor
public class ShortestPath {
    private Graph graph;
    private boolean[] visited;
    private int[] distance;
    private int[]path;

    public ShortestPath(Graph graph){
        this.graph = graph;

        distance= IntStream.range(0, graph.getAdjacentNodes().size()).map(i->i=Integer.MAX_VALUE).toArray();
        distance[0]=0;
        visited=new boolean[graph.getAdjacentNodes().size()];
        Arrays.fill(visited,false);
    }

    public int[] findShortestFromTo(int source, int target) {
        graph.getAdjacentNodes().forEach(node-> node.forEach(d-> {if (distance[d.getDestination()]>d.getWeight())
        {
            System.out.println(Arrays.toString(distance));
            distance[d.getDestination()]=d.getWeight()+ distance[d.getSource()];
        }}));
        return distance;
    }
/**  shortest 3->16 [0,2,3] 2->6[0,2] 1->3[0,1]
 *        1
 *      /  |
 *     3   |
 *   /    100
 * 0       |
 *   \     |
 *     6   |
 *      \  |
 *        2----10----3
 */
}
