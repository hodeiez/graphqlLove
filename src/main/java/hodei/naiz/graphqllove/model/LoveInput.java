package hodei.naiz.graphqllove.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Hodei Eceiza
 * Date: 5/9/2022
 * Time: 22:53
 * Project: graphqlLove
 * Copyright: MIT
 */
@Data
@AllArgsConstructor
public class LoveInput {
    @JsonProperty("type")
    private String type;
    @JsonProperty("amount")
    private int amount;

}
