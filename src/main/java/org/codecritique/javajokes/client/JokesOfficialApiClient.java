package org.codecritique.javajokes.client;


import com.external.jokes.rest.api.ExternalJokesServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "jokes-client", url = "${services.official-jokes-api.url}")
public interface JokesOfficialApiClient extends ExternalJokesServiceApi {
}
