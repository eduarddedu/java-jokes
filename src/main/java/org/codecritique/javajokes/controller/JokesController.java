package org.codecritique.javajokes.controller;

import com.codecritique.javajokes.api.JokesControllerApi;
import com.codecritique.javajokes.model.JokesResponse;
import lombok.RequiredArgsConstructor;
import org.codecritique.javajokes.service.JokesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JokesController implements JokesControllerApi {
    private final JokesService jokesService;

    @Override
    public ResponseEntity<JokesResponse> getJokes(Integer count) {
        return ResponseEntity.ok(jokesService.getJokes(count, "en"));
    }
}
