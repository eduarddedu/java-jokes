package org.codecritique.javajokes.e2e;

import com.codecritique.javajokes.model.JokesResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JokesControllerTests extends BaseIntegrationTest {

    @Test
    public void testGetJokes_noCountParam_expectDefaultCountValue() {
        String url = "http://localhost:{port}/jokes";
        ResponseEntity<JokesResponse> jokesResponse = restTemplate.getForEntity(url, JokesResponse.class, port);
        assertEquals(HttpStatus.OK, jokesResponse.getStatusCode());
        assertNotNull(jokesResponse.getBody());
        assertEquals(5, jokesResponse.getBody().getCount());
    }
}
