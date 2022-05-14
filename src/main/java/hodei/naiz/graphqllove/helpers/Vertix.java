package hodei.naiz.graphqllove.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Hodei Eceiza
 * Date: 5/10/2022
 * Time: 22:33
 * Project: graphqlLove
 * Copyright: MIT
 */
@Data
@AllArgsConstructor
public class Vertix {
    private int source;
    private int destination;
    private int weight;

    public int[] getNodes(){
        return source!=destination?new int[]{source,destination}:new int[]{source};
    }

}
