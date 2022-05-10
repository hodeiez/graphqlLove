package hodei.naiz.graphqllove.controller;

import hodei.naiz.graphqllove.model.Love;
import hodei.naiz.graphqllove.service.LoveService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Hodei Eceiza
 * Date: 5/9/2022
 * Time: 23:01
 * Project: graphqlLove
 * Copyright: MIT
 */

@Controller
@AllArgsConstructor
public class LoveController {
    private final LoveService loveService;

@QueryMapping("getAllLove")
public Flux<Love> getAllLove(){
    return loveService.getAllLove();
}
@MutationMapping("addLove")
    public Mono<Love> addLove(@Argument Love loveInput){
   return loveService.addLove(loveInput);

}


}
