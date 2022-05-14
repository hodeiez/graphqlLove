package hodei.naiz.graphqllove.helpers;

import org.junit.jupiter.api.Test;

/**
 * Created by Hodei Eceiza
 * Date: 5/10/2022
 * Time: 23:00
 * Project: graphqlLove
 * Copyright: MIT
 */

class GraphTest {
@Test
    public void buildGraph(){
    Graph g=new Graph(2);
    g.addNode(new Vertix(0,1,3));
    g.addNode(new Vertix(1,2,4));
    g.addNode(new Vertix(0,2,6));

   /* g.addNode(new Vertix(1,-1,0));
    g.addNode(new Vertix(2,-1,0));
*/

    System.out.println(g);
    System.out.println(g.getAdjacentNodes().get(0).get(1).getWeight());

}
}
