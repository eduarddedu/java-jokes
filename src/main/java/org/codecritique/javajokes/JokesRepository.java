package org.codecritique.javajokes;


import org.codecritique.javajokes.entity.JokeEntity;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JokesRepository extends MongoRepository<JokeEntity, String> {

    @Aggregation(pipeline = {
            "{$match:  {_class:  'org.codecritique.javajokes.entity.JokeEntity'} }",
            "{$limit:  ?0}"
    })
    AggregationResults<JokeEntity> getJokes(int limit);
}
