package org.codecritique.javajokes.unit;

import com.codecritique.javajokes.model.JokesResponse;
import com.external.jokes.rest.model.JokesExternalApiResponse;
import org.codecritique.javajokes.client.JokesOfficialApiClient;
import org.codecritique.javajokes.service.JokesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class JokesServiceTest extends BaseServiceTest {
    @MockBean
    private JokesOfficialApiClient jokesOfficialApiClientMockBean;

    @Autowired
    private JokesService jokesService;

    @Test
    void callGetJokes_expectRequestedJokesAmount() {
        when(jokesOfficialApiClientMockBean.getJokes(any(), any())).thenReturn(ResponseEntity.ok(getJokes()));
        JokesResponse serviceResponse = jokesService.getJokes(2, "en");
        assertEquals(2, serviceResponse.getCount());
    }
    private JokesExternalApiResponse getJokes() {
        return readFileAsObject("jokesExternalApiResponse.json", JokesExternalApiResponse.class);
    }

}
