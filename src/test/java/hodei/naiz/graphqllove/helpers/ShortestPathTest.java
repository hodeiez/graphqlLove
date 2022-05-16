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
    void getShortestPath() {
        Graph g=new Graph(6);
        g.addNode(new Vertix(0,2,6));
        g.addNode(new Vertix(0,1,3));

        g.addNode(new Vertix(1,2,1));
        g.addNode(new Vertix(2,3,10));
        g.addNode(new Vertix(3,4,3));
        g.addNode(new Vertix(1,4,2));
        g.addNode(new Vertix(3,5,2));
        ShortestPath st=new ShortestPath(g,1);

        assertEquals(Arrays.asList(0),st.getSelectedPath());
        assertEquals(3,st.getSelectedDistance());
        ShortestPath st2=new ShortestPath(g,2);

        assertEquals(Arrays.asList(0,1),st2.getSelectedPath());
        assertEquals(4,st2.getSelectedDistance());
        ShortestPath st3=new ShortestPath(g,3);

        assertEquals(Arrays.asList(0,1,2),st3.getSelectedPath());
        assertEquals(14,st3.getSelectedDistance());
        ShortestPath st4=new ShortestPath(g,4);

        assertEquals(Arrays.asList(0,1),st4.getSelectedPath());
        assertEquals(5,st4.getSelectedDistance());
        ShortestPath st5=new ShortestPath(g,5);

        assertEquals(Arrays.asList(0,1,2,3),st5.getSelectedPath());
        assertEquals(16,st5.getSelectedDistance());
    }

    /**  shortest 3->14 [0,1,2,3] 2->4[0,1,2] 1->3[0,1], 4->5[0,1,4], 5->16[0,1,2,3
     *         [1]--2--[4]
     *      /  |        /\
     *     3   |        |
     *   /    1         |
     * [0]     |        3
     *   \     |        |
     *     6   |        |
     *      \  |        |
     *        [2]--10--[3]----2---[5]
     */

    @Test
    void findShortestFromTo() {
        Graph g=new Graph(4);
        g.addNode(new Vertix(0,1,3));
        g.addNode(new Vertix(0,2,6));
        g.addNode(new Vertix(1,2,100));
        g.addNode(new Vertix(2,3,10));
        ShortestPath st=new ShortestPath(g);

        assertEquals(Arrays.toString(new int[]{0,3,6,16}),Arrays.toString(st.findShortestDistances()));
    }

    @Test
    void findShortestFromTo2() {
        Graph g=new Graph(4);
        g.addNode(new Vertix(0,2,6));
        g.addNode(new Vertix(0,1,3));

        g.addNode(new Vertix(1,2,1));
        g.addNode(new Vertix(2,3,10));
        ShortestPath st=new ShortestPath(g);
        assertEquals(Arrays.toString(new int[]{0,3,4,14}),Arrays.toString(st.findShortestDistances()));
    }


@Test
void findShortestFromTo3() {
    Graph g=new Graph(5);
    g.addNode(new Vertix(0,2,6));
    g.addNode(new Vertix(0,1,3));

    g.addNode(new Vertix(1,2,1));
    g.addNode(new Vertix(2,3,10));
    g.addNode(new Vertix(3,4,3));
    g.addNode(new Vertix(1,4,2));
    ShortestPath st=new ShortestPath(g);

    assertEquals(Arrays.toString(new int[]{0,3,4,14,5}),Arrays.toString(st.findShortestDistances()));
}


@Test
void findShortestFromTo4() {
    Graph g=new Graph(6);
    g.addNode(new Vertix(0,2,6));
    g.addNode(new Vertix(0,1,3));

    g.addNode(new Vertix(1,2,1));
    g.addNode(new Vertix(2,3,10));
    g.addNode(new Vertix(3,4,3));
    g.addNode(new Vertix(1,4,2));
    g.addNode(new Vertix(3,5,2));
    ShortestPath st=new ShortestPath(g);

    assertEquals(Arrays.toString(new int[]{0,3,4,14,5,16}),Arrays.toString(st.findShortestDistances()));
}
}
/**  shortest 3->14 [0,1,2,3] 2->4[0,1,2] 1->3[0,1], 4->5[0,1,4], 5->10[0,1,4
 *         [1]--2--[4]
 *      /  |        /\
 *     3   |        |
 *   /    1         |
 * [0]     |        3
 *   \     |        |
 *     6   |        |
 *      \  |        |
 *        [2]--10--[3]----2---[5]
 */
