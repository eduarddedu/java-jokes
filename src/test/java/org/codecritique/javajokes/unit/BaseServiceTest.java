package org.codecritique.javajokes.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseServiceTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    protected String readFile(String fileName) throws IOException {
        return Files.readString(Paths.get("src/test/resources/", fileName));
    }

    @SneakyThrows
    protected <T> T readFileAsObject(String fileName, Class<T> targetClass) {
        return objectMapper.readValue(readFile(fileName), targetClass);
    }
}
