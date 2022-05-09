package hodei.naiz.graphqllove.repos;

import hodei.naiz.graphqllove.model.Love;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Hodei Eceiza
 * Date: 5/9/2022
 * Time: 22:28
 * Project: graphqlLove
 * Copyright: MIT
 */
@Repository
public interface LoveRepo extends ReactiveCrudRepository<Love,Integer> {
Flux<Love> findAllByType(String type);
Flux<Love> findAllByAmount(int amount);
Mono<Love> findLoveById(int id);

}
