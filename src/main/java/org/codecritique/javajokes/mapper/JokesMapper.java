package org.codecritique.javajokes.mapper;

import com.codecritique.javajokes.model.JokeResponse;
import com.codecritique.javajokes.model.JokesResponse;

import java.util.List;
import java.util.stream.Collectors;

import com.external.jokes.rest.model.JokeExternalApiResponse;
import com.external.jokes.rest.model.JokesExternalApiResponse;
import org.codecritique.javajokes.entity.JokeEntity;
import org.springframework.stereotype.Service;

@Service
public class JokesMapper {

    public List<JokeEntity> map(JokesExternalApiResponse jokesExternalApiResponse) {
        return jokesExternalApiResponse.getJokes().stream().map(this::map).collect(Collectors.toList());
    }

    public JokeEntity map(JokeExternalApiResponse jokeResponse) {
        return new JokeEntity().withExternalId(jokeResponse.getId())
                .withCategory(jokeResponse.getCategory())
                .withJoke(jokeResponse.getJoke());
    }

    public JokesResponse map(List<JokeEntity> jokes) {
        return new JokesResponse().count(jokes.size())
                .items(jokes.stream().map(this::map).collect(Collectors.toList()));
    }

    public JokeResponse map(JokeEntity jokeEntity) {
        return new JokeResponse()
                .externalId(jokeEntity.getExternalId())
                .category(jokeEntity.getCategory())
                .joke(jokeEntity.getJoke());
    }
}
