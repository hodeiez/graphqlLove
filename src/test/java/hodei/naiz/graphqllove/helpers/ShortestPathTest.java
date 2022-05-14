package hodei.naiz.graphqllove.helpers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Hodei Eceiza
 * Date: 5/12/2022
 * Time: 23:42
 * Project: graphqlLove
 * Copyright: MIT
 */
class ShortestPathTest {

    @Test
    void findShortestFromTo() {
        Graph g=new Graph(4);
        g.addNode(new Vertix(0,1,3));
        g.addNode(new Vertix(0,2,6));
        g.addNode(new Vertix(1,2,100));
        g.addNode(new Vertix(2,3,10));
        ShortestPath st=new ShortestPath(g);
        System.out.println(Arrays.toString(st.findShortestFromTo(0, 99)));
        System.out.println(g.getAdjacentNodes().get(0));
        assertEquals(Arrays.toString(new int[]{0,3,6,16}),Arrays.toString(st.findShortestFromTo(0, 99)));
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
    @Test
    void findShortestFromTo2() {
        Graph g=new Graph(4);
        g.addNode(new Vertix(0,1,3));
        g.addNode(new Vertix(0,2,6));
        g.addNode(new Vertix(1,2,1));
        g.addNode(new Vertix(2,3,10));
        ShortestPath st=new ShortestPath(g);
        System.out.println(Arrays.toString(st.findShortestFromTo(0, 99)));
        System.out.println(g.getAdjacentNodes().get(0));
        assertEquals(Arrays.toString(new int[]{0,3,4,14}),Arrays.toString(st.findShortestFromTo(0, 99)));
    }
}
/**  shortest 3->16 [0,1,2,3] 2->4[0,1,2] 1->3[0,1]
 *        1
 *      /  |
 *     3   |
 *   /    1
 * 0       |
 *   \     |
 *     6   |
 *      \  |
 *        2----10----3
 */
