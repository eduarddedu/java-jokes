package org.codecritique.javajokes.e2e;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {
    @LocalServerPort
    protected int port;
    protected final RestTemplate restTemplate = new RestTemplate();

}
