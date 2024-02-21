package org.codecritique.javajokes.service;

import com.external.jokes.rest.model.JokesExternalApiResponse;
import lombok.RequiredArgsConstructor;
import org.codecritique.javajokes.client.JokesOfficialApiClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JokesBatchGetService {
    private final JokesOfficialApiClient jokesOfficialApiClient;
    private final static int BATCH_SIZE = 10;

    public JokesExternalApiResponse getJokes(Integer amount, String lang) {
        final int batchSize = amount == null ? BATCH_SIZE : amount;
        ResponseEntity<JokesExternalApiResponse> jokesExternalApiResponse = jokesOfficialApiClient.getJokes(batchSize, lang);
        return jokesExternalApiResponse.getBody();
    }

}
