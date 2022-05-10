package hodei.naiz.graphqllove.service;

import hodei.naiz.graphqllove.model.Love;
import hodei.naiz.graphqllove.repos.LoveRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Hodei Eceiza
 * Date: 5/9/2022
 * Time: 22:56
 * Project: graphqlLove
 * Copyright: MIT
 */
@Service
@AllArgsConstructor
public class LoveService {
    private final LoveRepo loveRepo;

    public Mono<Love> addLove(Love loveInput){
        return loveRepo.save(new Love(loveInput));
    }
    public Flux<Love> getAllLove(){
        return loveRepo.findAll();
    }
}
