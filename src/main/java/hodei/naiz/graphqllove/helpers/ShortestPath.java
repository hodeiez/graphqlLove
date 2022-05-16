package hodei.naiz.graphqllove.helpers;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



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
    private List<Integer> selectedPath;
    private int selectedDistance;
    public ShortestPath(Graph graph){
        this.graph = graph;

        distance= IntStream.range(0, graph.getAdjacentNodes().size()).map(i->i=Integer.MAX_VALUE).toArray();
        distance[0]=0;
        paths=new HashMap<>();
    }
    public ShortestPath(Graph graph,int target){
        this.graph = graph;
        distance= IntStream.range(0, graph.getAdjacentNodes().size()).map(i->i=Integer.MAX_VALUE).toArray();
        distance[0]=0;
        paths=new HashMap<>();
        calculateShortestPaths();
        setPathTo(target);
        setSelectedDistance(target);

    }

    public int getSelectedDistance() {
        return selectedDistance;
    }

    public List<Integer> getSelectedPath() {
        return selectedPath;
    }

    public void calculateShortestPaths(){
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
    protected int[] findShortestDistances() {
        calculateShortestPaths();

        return distance;
    }
    public void setPathTo(int target){

       selectedPath=paths.entrySet().stream().filter(m->m.getKey()==target).map(Map.Entry::getValue).flatMap(Collection::parallelStream).collect(Collectors.toList());

        while(!selectedPath.contains(0)){
            List<Integer> finalTarget = selectedPath;
            selectedPath.addAll(paths.entrySet().stream().filter(m-> m.getKey().equals(finalTarget.get(0))).map(Map.Entry::getValue).flatMap(Collection::parallelStream).collect(Collectors.toList()));
            selectedPath=selectedPath.stream().sorted().collect(Collectors.toList());
        }
    }
    public void setSelectedDistance(int target){
        selectedDistance=distance[target];
    }

}
