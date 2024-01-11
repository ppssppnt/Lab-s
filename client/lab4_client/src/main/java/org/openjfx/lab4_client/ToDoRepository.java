package org.openjfx.lab4_client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class ToDoRepository {

    private static final String BASE_URL = "http://localhost:8080/api/todo";

    private final ObjectMapper objectMapper;

    public ToDoRepository() {
        this.objectMapper = new ObjectMapper();
    }

    public List<ToDo> getAllToDos() throws IOException, URISyntaxException {
        URL url = new URI(BASE_URL).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, ToDo.class);
            return objectMapper.readValue(connection.getInputStream(), listType);
        } else {
            throw new IOException("Failed to fetch ToDos, HTTP error code: " + connection.getResponseCode());
        }
    }

    public ToDo getToDoById(String id) throws IOException, URISyntaxException {
        URL url = new URI(BASE_URL + "/" + id).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            return objectMapper.readValue(connection.getInputStream(), ToDo.class);
        } else {
            throw new IOException("Failed to fetch ToDo, HTTP error code: " + connection.getResponseCode());
        }
    }

    // Другие методы для создания, обновления и удаления ToDo

    // Пример:
    public void createToDo(ToDo toDo) throws IOException, URISyntaxException {
        URL url = new URI(BASE_URL).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        objectMapper.writeValue(connection.getOutputStream(), toDo);

        if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            throw new IOException("Failed to create ToDo, HTTP error code: " + connection.getResponseCode());
        }
    }
}
