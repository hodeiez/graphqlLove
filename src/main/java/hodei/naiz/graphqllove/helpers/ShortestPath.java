package hodei.naiz.graphqllove.helpers;

import lombok.AllArgsConstructor;

import java.util.*;
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
    private int[] distance;
    private HashMap<Integer,Set<Integer>> paths;

    public ShortestPath(Graph graph){
        this.graph = graph;

        distance= IntStream.range(0, graph.getAdjacentNodes().size()).map(i->i=Integer.MAX_VALUE).toArray();
        distance[0]=0;
        paths=new HashMap<Integer,Set<Integer>>();

    }
    private void calculateShortestPaths(){
        graph.getAdjacentNodes().forEach(node-> node.forEach(d-> {
            if (distance[d.getDestination()]>d.getWeight() && distance[d.getDestination()]>d.getWeight()+ distance[d.getSource()])
            {

                if(paths.get(d.getDestination())!=null){
                    var list= paths.get(d.getDestination());
                    list.add(d.getSource());
                    paths.put(d.getDestination(),list);
                }else {
                    var list2=new HashSet();
                    list2.add(d.getSource());
                    paths.put(d.getDestination(), list2);
                }
                distance[d.getDestination()]=d.getWeight()+ distance[d.getSource()];

            }}));


    }
    public int[] findShortestFromTo(int source, int target) {
        calculateShortestPaths();
    dataPresentation();
        return distance;
    }
    private void dataPresentation(){
        //System.out.println(paths.get(2));
        paths.forEach((k,v)-> System.out.println(paths));
        System.out.println(paths);
        System.out.println(Arrays.toString(distance));
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
