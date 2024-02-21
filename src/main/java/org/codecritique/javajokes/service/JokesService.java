package org.codecritique.javajokes.service;

import com.codecritique.javajokes.model.JokesResponse;
import com.external.jokes.rest.model.JokesExternalApiResponse;
import lombok.RequiredArgsConstructor;
import org.codecritique.javajokes.JokesRepository;
import org.codecritique.javajokes.entity.JokeEntity;
import org.codecritique.javajokes.mapper.JokesMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JokesService {
    private final JokesBatchGetService batchGetService;
    private final JokesMapper mapper;
    private final JokesRepository jokesRepository;

    public JokesResponse getJokes(int requestedAmount, String lang) {
        List<JokeEntity> storedJokes = jokesRepository.getJokes(requestedAmount).getMappedResults();
        int remainder = requestedAmount - storedJokes.size();
        if (remainder >= 2) {
            JokesExternalApiResponse jokesExternalApiResponse = batchGetService.getJokes(remainder, lang);
            List<JokeEntity> newJokes = mapper.map(jokesExternalApiResponse);
            jokesRepository.saveAll(newJokes);
            storedJokes.addAll(newJokes);
        }
        return mapper.map(storedJokes);
    }
}
