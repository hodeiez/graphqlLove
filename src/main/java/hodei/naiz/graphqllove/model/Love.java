package hodei.naiz.graphqllove.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


/**
 * Created by Hodei Eceiza
 * Date: 5/9/2022
 * Time: 21:48
 * Project: graphqlLove
 * Copyright: MIT
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Love {
    @Id
    private int id;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("type")
    private String type;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Love(LoveInput loveInput){
        this.amount=loveInput.getAmount();
        this.type=loveInput.getType();
    }
}
